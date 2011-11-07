package org.jcryptool.visual.des.algorithm;

import java.awt.Component;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.Vector;
import java.util.Random;

//Wird automatisch von der JVM aufgerufen
public class CustomTableCellRenderer extends DefaultTableCellRenderer
{
        //Die Einfaerbung der Tabellen beeinflusst wesentlich die Programm-Performance !!!
        Vector data;
        
        Color c1 = new Color(247,250,114);  //gelb
        Color c2 = new Color(148,178,246);  //blau
        Color c3 = new Color(210,253,115);  //lemon
        
        Color c01 = new Color(189,247,111);   //soft-lemon       
        Color c02 = new Color(30,249,254);    //tuerkis-blau
        Color c03 = new Color(67,247,140);    //gruen-blau
        Color c04 = new Color(252,174,196);   //hell-lila       
        Color c05 = new Color(215,251,33);    //lemon-gelb
        Color c06 = new Color(177,198,232);   //grau-blau
        //Color c07 = new Color(250,232,164); //hell-beige
        Color c07 = new Color(170,234,126);   //hell-gruen
        Color c08 = new Color(252,184,254);   //rosa
        Color c09 = new Color(252,249,111);   //gelb-ocker
        
        Color c10 = new Color(255,151,151);     //soft-red
        Color c11 = new Color(222,255,189);     //soft-lemon-green
        
        //COLORS pro Zeile von li --> re
        Color [] COLORS = { c1,c1,c1,c1,c2,c2,c2,c2,c1,c1,c1,c1,c2,c2,c2,c2,c1,c1,c1,c1,c2,c2,c2,c2,c1,c1,c1,c1,c2,c2,c2,c2,c1,c1,c1,c1,c2,c2,c2,c2,c1,c1,c1,c1,c2,c2,c2,c2,c1,c1,c1,c1,c2,c2,c2,c2,c1,c1,c1,c1,c2,c2,c2,c2 };                          
        Color [] REVERSE_COLORS = { c2,c2,c2,c2,c1,c1,c1,c1,c2,c2,c2,c2,c1,c1,c1,c1,c2,c2,c2,c2,c1,c1,c1,c1,c2,c2,c2,c2,c1,c1,c1,c1,c2,c2,c2,c2,c1,c1,c1,c1,c2,c2,c2,c2,c1,c1,c1,c1,c2,c2,c2,c2,c1,c1,c1,c1,c2,c2,c2,c2,c1,c1,c1,c1 };                          
        Color [] CDColors = { c1,c1,c2,c2,c1,c1,c2,c2,c1,c1,c2,c2,c1,c1,c2,c2,c1,c1,c2,c2,c1,c1,c2,c2,c1,c1,c2,c2,c1,c1,c2,c2,c1,c1 };
        
        int [] rows = new int[8]; //= { 0,8,9,10,11,12,13,14 };                 //fuer Panel Rundenkeys K_i
        Color [] m8colors = { c01, c02, c03, c04, c05, c06, c07, c08, c09 };    //fuer Panel m[0]->m[17]   
        Color [] color64 = new Color[64];                                       //fuer Panel DES(k, p+e_i)
        
        boolean status = false; //Status zeigt an, ob Foreground-Coloring aktiviert werden soll
        int DES_action_type = -1;
        int index = -1;
                       
        public void generate64Colors()
        {       //Befuellt das Array "color64" mit 64 zufaelligen Farben. Wird benutzt im Panel "DES(k, p+e_i)"    (Panel 4)
                for(int k=0; k < color64.length; k++)
                {
                   Random generator = new Random();
                   color64[k] = new Color(generator.nextInt(255), generator.nextInt(255), generator.nextInt(255), 120);
                }                                  
        }
        
        //Konstruktor   CustomTableCellRenderer           
        public CustomTableCellRenderer(Vector scan_data, boolean status, int index, int DES_action_type)
        {    //Vector data
             data = scan_data; 
             this.status = status;
             this.index = index;
             this.DES_action_type = DES_action_type;
             generate64Colors();
        }
              
        public void setTabIndex(int index)
        {
                this.index = index;
        }
        
        //Liefert Status des Vektors "data" in (row,col) ==> Einfaerbung bzgl. diesem Rueckgabewert
        public boolean getStatus(int row, int col)
        {       
                boolean result = false;
                for(int k=0; k<data.size(); k++)
                {
                        Data d = (Data)data.elementAt(k);  // CASTING, since nobody knows what is in "Vector data"
                        if( d.getRow()==row && d.getCol()==col )
                        {
                              result = d.getStatus();
                              break;
                        }
                }
                return result;
        }
   
       //Diese Methode wird bei jeder Aenderung in "table" automatisch von der JVM aufgerufen
       //Individuelle Einfaerbung in Abhaengigkeit vom Tab-Index
       //Cell only accepts objects
       //isSelected (manual) = false
       //hasFocus (Tab) = false
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
        {										 
                Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if(index==7) // Panel ANTI-/FIXED POINTS
                {
                    if( value instanceof Integer )  //Ist "value" Instanz vom Typ Integer ?
                    {       
                        cell.setBackground( COLORS[column-1] );
                        if( getStatus(row,column) )               //Bool-Status des Vektors "data" in (row,column)
                        {
                                      if(column>0 && column<33)
                                      { //Faerbung mit rot/schwarz je nach cell-status
                                        if(status)
                                            cell.setForeground(Color.RED);
                                        else 
                                           cell.setForeground(Color.black);
                                      }                       
                        }
                        else
                        {	
                                    cell.setForeground(Color.black);
                        }
                    }
                    else 
                    {    
                        cell.setBackground(Color.white); //Falls "value" keine Instanz vom Typ Integer
                        cell.setForeground(Color.black);
                    }
                }
                else if(index==4)   // Panel  p~1/2       (Faerbung analog zu index==7)
                {
                    if( value instanceof Integer )  //Ist "value" vom Typ Integer ? 
                    {
                        cell.setBackground(c3);
                        if( getStatus(row,column) )
                        {
                                      if(column>0 && column<9)
                                      { //Faerbung mit rot/schwarz je nach cell-Status
                                        if(status)
                                            cell.setForeground(Color.red);
                                        else 
                                           cell.setForeground(Color.black);
                                      }                               
                        }
                        else
                        {	
                                cell.setForeground(Color.black);
                        }
                    }            
                    else 
                    {    
                        cell.setBackground(Color.white); 
                        cell.setForeground(Color.black);
                    }
                }
                else if(index==5)     // Panel Roundkeys K_i
                {
                    if( value instanceof Integer )   //Ist "value" vom Typ Integer ?
                    {                          
                           boolean flag = false;
                           int rows [];
                           if(DES_action_type==0)
                                rows = new int [] { 0,8,9,10,11,12,13,14 }; //Fuer Farbstruktur im Panel "Roundkeys K_i"
                                else
                                rows = new int [] { 1,2,3,4,5,6,7,15 };     //Fuer Farbstruktur im Panel "Roundkeys K_i" 
                               
                           for(int k=0; k<rows.length; k++)
                           {
                                   if(row==rows[k])
                                   {
                                           cell.setBackground(REVERSE_COLORS[column-1]);
                                           flag = true;
                                           break;
                                   }
                           }
                           
                           if(!flag)  cell.setBackground(COLORS[column-1]);
                              
                            if( getStatus(row,column) )
                            {
                                      if(column>0 && column<49)
                                      {
                                        if(status)
                                            cell.setForeground(Color.red);
                                        else 
                                           cell.setForeground(Color.black);
                                      }                                                               
                            }
                            else	
                                cell.setForeground(Color.black);
                    }
                    else 
                    {    
                        cell.setBackground(Color.white ); 
                        cell.setForeground(Color.black);
                    }                        
                }
                else if(index==2)    // Panel m[0]--m[17]
                {
                    if( value instanceof Integer )  //Ist "value" vom Typ Integer ?
                    {
                           switch(row)
                           {
                                     case 0:  cell.setBackground(m8colors[0]); break;    
                                     case 1:  cell.setBackground(m8colors[1]); break; 
                                     case 2:  cell.setBackground(m8colors[2]); break;
                                     case 3:  cell.setBackground(m8colors[3]); break;  
                                     case 4:  cell.setBackground(m8colors[4]); break;
                                     case 5:  cell.setBackground(m8colors[5]); break;
                                     case 6:  cell.setBackground(m8colors[6]); break;
                                     case 7:  cell.setBackground(m8colors[7]); break;  
                                     case 8:  cell.setBackground(m8colors[8]); break;
                                     case 9:  cell.setBackground(m8colors[8]); break;
                                     case 10: cell.setBackground(m8colors[7]); break;
                                     case 11: cell.setBackground(m8colors[6]); break;
                                     case 12: cell.setBackground(m8colors[5]); break;
                                     case 13: cell.setBackground(m8colors[4]); break;
                                     case 14: cell.setBackground(m8colors[3]); break;
                                     case 15: cell.setBackground(m8colors[2]); break;
                                     case 16: cell.setBackground(m8colors[1]); break;
                                     case 17: cell.setBackground(m8colors[0]); break;
                            }
                           
                           
                            if( getStatus(row,column) )
                            {
                                if(column>0 && column<33)
                                {
                                    if(status)
                                        cell.setForeground(Color.red);
                                    else 
                                        cell.setForeground(Color.black);
                                }          
                            }
                            else
                            {	
                                cell.setForeground(Color.black);
                            }
                        }
                        else 
                        {    
                            cell.setBackground(Color.white); 
                            cell.setForeground(Color.black);
                        }                        
                }
                else if(index==3)  // Panel DES(k, p+e_i)
                {
                    if( value instanceof Integer )   //Ist "value" vom Typ Integer ?
                    {
                           int r=0;
                           while(r<65)
                           {
                                 if(r==row)
                                 {
                                         if(r%2!=0) // Alternierend  Farbe-White-Farbe-White- ......
                                            cell.setBackground(color64[r]);
                                         else
                                            cell.setBackground(Color.white);
                                            
                                         break;
                                 }
                                 r++;  
                           }
                                                     
                           
                        if( getStatus(row,column) )
                        {
                                    if(column>0 && column<65)
                                    {
                                        if(status)
                                            cell.setForeground(Color.red);
                                        else 
                                           cell.setForeground(Color.black);
                                      }                                
                        }
                        else
                        {	
                                cell.setForeground(Color.black);
                        }
                    }
                    else 
                    {    
                        cell.setBackground(Color.white); 
                        cell.setForeground(Color.black);
                    }                        
                }
                else if(index==6) // Panel CD_Matrix
                {
                    if( value instanceof Integer )   //Ist "value" vom Typ Integer ?
                    {
                           int r=0;
                           while(r<34)
                           {
                                 if(r==row)
                                 {
                                         cell.setBackground(CDColors[r]);   
                                         break;
                                 }
                                 r++;  
                           }                          
                           
                        if( getStatus(row, column) )
                        {
                                      if(column>0 && column<29)
                                      {
                                        if(status)
                                            cell.setForeground(Color.red);
                                        else 
                                           cell.setForeground(Color.black);
                                      }                                     
                        }
                        else	
                                cell.setForeground(Color.black);
                    }
                   else 
                   {    
                        cell.setBackground(Color.white ); 
                        cell.setForeground(Color.black);
                   } 
                }   

                if(index==8) // Panel DKA ************** DKA ******************
                {       
                    if( getStatus(row,column) )               //Bool-Status des Vektors "data" in (row,column)
                    {
                                if(column >=0  &&  column<8)
                                {
                                    if(status)  
                                    {
                                        cell.setForeground(c10);
                                        cell.setBackground(c10);
                                    }
                                    else        
                                    {
                                        cell.setForeground(c11);
                                        cell.setBackground(c11);
                                    }
                                }                       
                    }
                    else   
                    {
                                   cell.setForeground(c3);
                                   cell.setBackground(c3);  
                    }                                 		   
                }

                   
		return cell;
        }
}