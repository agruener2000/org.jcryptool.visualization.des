package org.jcryptool.visual.des.algorithm;

public class Data 
{
      int row;
      int col;
      boolean status;
      
      //Konstruktor von Data
      public Data(int row, int col, boolean status)
      {
              this.row    = row;
              this.col    = col;
              this.status = status; //Benutzt zum Anzeigen des Wechsels 0 auf 1 ==> rot einfaerben
      }
      
      public int getRow()
      {
              return row;
      }
      
      public void setRow(int row)
      {
              this.row = row;
      }
      
      public int getCol()
      {
              return col;
      }
      
      public void setCol(int col)
      {
              this.col = col;
      }
      
      public boolean getStatus()
      {
              return status;
      }
      
      public void setStatus(boolean new_status)
      {
              status = new_status;
      }
      

      
        
}