
import java.awt.Color;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ajay
 */
public class Game {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //create the game board
        Board board = new Board(12, 12);

        Doctor doc = new Doctor((int) (Math.random() * 12), (int) (Math.random() * 12));
        Dalek dk1 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        Dalek dk2 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        Dalek dk3 = new Dalek((int) (Math.random() * 12), (int) (Math.random() * 12));
        board.putPeg(Color.black, dk3.getrow(), dk3.getcol());
        board.putPeg(Color.black, dk2.getrow(), dk2.getcol());
        board.putPeg(Color.black, dk1.getrow(), dk1.getcol());
        board.putPeg(Color.GREEN, doc.getRow(), doc.getCol());
        //out a message on a board
        board.displayMessage("Please click the board");

        while (true) {

            Coordinate click = board.getClick();

            board.removePeg(doc.getRow(), doc.getCol());
            int row = click.getRow();
            int col = click.getCol();
           
            doc.move(row, col);

            int newRow = doc.getRow();
            int newCol = doc.getCol();
           

            board.putPeg(Color.GREEN, doc.getRow(), doc.getCol());
            if (dk1.hasDied != true) {
                board.removePeg(dk1.getrow(), dk1.getcol());
                dk1.advanceTowards(doc);
                board.putPeg(Color.black, dk1.getrow(), dk1.getcol());

            }
            if(dk2.hasDied != true){
            board.removePeg(dk2.getrow(), dk2.getcol());
            dk2.advanceTowards(doc);
            board.putPeg(Color.black, dk2.getrow(), dk2.getcol()); 
            }
            if(dk3.hasDied != true){
            board.removePeg(dk3.getrow(), dk3.getcol());
            dk3.advanceTowards(doc);
            board.putPeg(Color.black, dk3.getrow(), dk3.getcol());
            }

            if (dk1.getrow() == dk2.getrow() && dk1.getcol() == dk2.getcol()) {
                board.putPeg(Color.RED, dk1.getrow(), dk1.getcol());
                board.putPeg(Color.RED, dk2.getrow(), dk2.getcol());
                dk1.hasDied = true;
                dk2.hasDied = true;
                System.out.println("Dalek 1 and 2 have died");
            }

            if (dk2.getrow() == dk3.getrow() && dk2.getcol() == dk3.getcol()) {
                board.putPeg(Color.RED, dk2.getrow(), dk2.getcol());
                board.putPeg(Color.RED, dk3.getrow(), dk3.getcol());
                dk3.hasDied = true;
                dk2.hasDied = true;
                System.out.println("Dalek 3 and 2 have died");
            }

            if (dk1.getrow() == dk3.getrow() && dk1.getcol() == dk3.getcol()) {
                board.putPeg(Color.RED, dk1.getrow(), dk1.getcol());
                board.putPeg(Color.RED, dk3.getrow(), dk3.getcol());
                dk1.hasDied = true;
                dk3.hasDied = true;
                System.out.println("Dalek 1 and 3 have died");
            }
            

            if (dk1.getrow() == doc.getRow() && dk1.getcol() == doc.getCol()
                    || dk2.getrow() == doc.getRow() && dk2.getcol() == doc.getCol()
                    || dk3.getrow() == doc.getRow() && dk3.getcol() == doc.getCol()) {

                board.putPeg(Color.YELLOW, doc.getRow(), doc.getCol());
                System.out.println("The doctor has been caught, you LOSE");
                break;
            }
            if(dk1.havetheyDied == true && dk2.havetheyDied == true && dk3.havetheyDied == true){
                System.out.println("You WON");
                break;
            }
        }
    }
}
