/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ajay
 */
public class Doctor {
   
      private int Row;
      private int Col;
     
     
      public Doctor(int Row, int Col){
          this.Row = Row;
          this.Col = Col;
         
      }

      void move(int nrow, int ncol) {
        int rRow = (int) (Math.random() * 12);
        int rCol = (int) (Math.random() * 12);
        int rowMove = this.Row - nrow;
        int colMove = this.Col - ncol;
        if (rowMove <= 1 && rowMove >= -1 && colMove <= 1 && colMove >= -1) {
            this.Col = ncol;
            this.Row = nrow;
    }else{
            this.Col = rCol;
            this.Row = rRow;
        }
    }  

      public int getRow(){
      return this.Row;

}
      public int getCol(){
      return this.Col;
}
      
     
}