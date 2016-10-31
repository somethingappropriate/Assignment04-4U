/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ajay
 */
public class Dalek {
    private int row;
    private int col;
    boolean hasDied;
    boolean havetheyDied;
 
    public Dalek(int row, int col){
          this.row = row;
          this.col = col;
         
    }
     
    public void advanceTowards(Doctor doc){
        int Row = doc.getRow();
        int Col = doc.getCol();
        
        int rm = this.row - Row;
        int cm = this.col - Col;
       if(hasDied){
           
       }else
        if(!hasDied){
        if(rm <=0){         
            this.row++;
        }
        if(rm >=0){
            this.row--;
        }
        if(cm <=0){
            this.col++;
        }
        if(cm >=0){
            this.col--;
        }
        }
    }  
      
    public int getrow(){
      return this.row;

}
    public int getcol(){
      return this.col;
}

     public boolean havetheyDied(){
         return this.havetheyDied;
     }   
       
    public void hasDied(){
      this.havetheyDied = true;   
         
    }
}
