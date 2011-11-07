package org.jcryptool.visual.des.algorithm;

import java.awt.*;
import javax.swing.table.*;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.event.*;
import java.awt.event.*;
import java.awt.image.*;
import java.util.Vector;
import java.util.Random;
import javax.swing.text.*;
import java.net.*;


public class GUIMain extends JApplet implements ActionListener                  //    march/2009
{ 
   JTabbedPane tabbedPane;
   
    String [] tips = {
        "Definitions", "Key / Plaintext", "m[0]->m[17]", "DES(k, p+e_i)", "p � 32/64", "Roundkeys K_j","CD - Matrix", "Fixed Points","Active S-Boxes" };
    
    String [] texts = {
         "Definitions", "Key / Plaintext", "m[0]->m[17]", "DES(k, p+e_i)", "p � 32/64", "Roundkeys K_j","CD - Matrix", "Fixed Points", "Active S-Boxes" };

    String [] errors ={ "The Hex-length of the MANUAL KEY or the INPUT is not 16.",
                        "The MANUAL KEY or the INPUT doesn't consist entirely of Hex-digits.",
                        "The MANUAL KEY has an INVALID parity inside.",
                        "Hex-Digits or Hex-length of the INPUT is wrong." };

                        
    String [] errors_DKA ={ "Your INPUT's Hex-length is not 16.",
                            "Your INPUT doesn't consist entirely of Hex-digits.",
                            "Your MANUAL KEY has an INVALID parity inside.",
                            "Hex-Digits or length of your INPUT is wrong." };
    
    //*******************************************************************
    //Tool tips for unlimited time
    // Get current delay
    //int dismissDelay = ToolTipManager.sharedInstance().getDismissDelay();
    
    // Keep the tool tip showing
    //int dismissDelay = Integer.MAX_VALUE;
    //ToolTipManager.sharedInstance().setDismissDelay(dismissDelay);
    //*******************************************************************
    
    //********** alle Tabellen (Panels 2-8) ***********************************
    JTable output1 = new JTable(18,34); //m[0]--m[17]
    JTable output2 = new JTable(65,66); //DES(k, p+e_i)
    JTable output3 = new JTable(16,50); //Roundkeys K_j
    JTable output4 = new JTable(34,29); //CD_Matrix
    JTable output5 = new JTable(10,34); //m[8]--m[17]
    JTable output6 = new JTable(8,8);   //Dist1_Matrix   
    JTable output7 = new JTable(8,8);   //Dist2_Matrix
    JTable output8 = new JTable(16,8);  //DKA-Matrix
    
    JTable header1 = new JTable(1,10);  //fuer m[0]--m[17]
    JTable header2 = new JTable(1,18);  //fuer DES(k, p+e_i)
    JTable header3 = new JTable(1,14);  //fuer Roundkeys K_j
    JTable header5 = new JTable(1,10);  //fuer m[8]--m[17]
    JTable header6 = new JTable(1,8);  //Header-Zeile in DKA-Matrix

       
    //********* Radio-Buttons im Panel "EN-/DECRYPT" (Panel 2) *****************************************
    JRadioButton encrypt = new JRadioButton("ENCRYPT");
    JRadioButton decrypt = new JRadioButton("DECRYPT");
    
    JRadioButton k0   = new JRadioButton("k(0)");  // 8 pre-defined keys
    JRadioButton k3   = new JRadioButton("k(3)");
    JRadioButton k5   = new JRadioButton("k(5)");
    JRadioButton k6   = new JRadioButton("k(6)");
    JRadioButton k9   = new JRadioButton("k(9)");
    JRadioButton k10  = new JRadioButton("k(10)");
    JRadioButton k12  = new JRadioButton("k(12)");
    JRadioButton k15  = new JRadioButton("k(15)");
    JRadioButton khex = new JRadioButton("");       // the manual key
    
    
    //************** Radio-Buttons im Panel "ANTI-/FIXED POINTS" (Panel 8) ********************
    JRadioButton fixed      = new JRadioButton("FIXED POINT");
    JRadioButton anti_fixed = new JRadioButton("ANTI-FIXED POINT");
    
    JRadioButton fk0  = new JRadioButton("k(0)");
    JRadioButton fk3  = new JRadioButton("k(3)");
    JRadioButton fk5  = new JRadioButton("k(5)");
    JRadioButton fk6  = new JRadioButton("k(6)");
    JRadioButton fk9  = new JRadioButton("k(9)");
    JRadioButton fk10 = new JRadioButton("k(10)");
    JRadioButton fk12 = new JRadioButton("k(12)");
    JRadioButton fk15 = new JRadioButton("k(15)");
    
    
    //************** Felder for INPUTS/OUTPUTS  (Panel 2 + 8) ***********************
    JTextField in_hex   = new JTextField();  // EN-/DECRYPT (INPUT in hex-notation)
    JTextField out_hex  = new JTextField();  // EN-/DECRYPT (OUTPUT in hex-notation)
    JTextField out_bin  = new JTextField();  // EN-/DECRYPT (OUTPUT in binary-notation)
    JTextField key_hex  = new JTextField();  // EN-/DECRYPT (manual key in hex-notation)
    
    
    JTextField inf_bin  = new JTextField();  // INPUT for Fixed Pts.  (32-bit binary)
    JTextField outf_hex = new JTextField();  // OUTPUT for Fixed Pts. (in hex-notation)
    
    JTextField in_dka       = new JTextField();     //INPUT for DKA
    JTextField random_k_dka = new JTextField();     //RANDOM k for DKA
    JTextField random_m_dka = new JTextField();     //RANDOM m for DKA

    
    //Action-Buttons  (Panel 2 + 8 + 9)
    JButton in1_action = new JButton("Evaluate   OUTPUT,    Round- / Ciphers,    p � 32/64,    Roundkeys K_j,    CD-Matrix");
    JButton in2_action = new JButton("Evaluate   the   ANTI-/ FIXED POINT");
    JButton in3_action = new JButton("Show   ACTIVE  S-BOXES");
    
    Vector scan_data1 = new Vector();// use for later
    Vector scan_data2 = new Vector();// use for later
    
    //initialisation
    public void init()
    {
        JPanel  panel_def           = new JPanel();     //Panel 1 = DEFINITIONS
        JPanel  panel_ENCRYPT       = new JPanel();     //Panel 2 = KEY / PLAINTEXT
        JPanel  panel_m             = new JPanel();     //Panel 3 = m[0]-m[18]        
        JPanel  panel_DES           = new JPanel();     //Panel 4 = DES(k, p+e_i)
        JPanel  panel_dist_matrices = new JPanel();     //Panel 5 = Two 8x8 Matrices:   dist(DES[k,p+e_0], DES[k,p+e_i])
        JPanel  panel_roundkeys     = new JPanel();     //Panel 6 = Roundkeys K_j
        JPanel  panel_CD_matrix     = new JPanel();     //Panel 7 = CD-Matrix
        JPanel  panel_ANTI_FIXED_PTS = new JPanel();    //Panel 8 = ANTI-/FIXED POINTS
        JPanel  panel_DKA           = new JPanel();     //Panel 9 = Active S-Boxes
        
        //Dimensionen for header und output-tables
        int width   = 1200;
        int height1 =   33;
        int height2 =  340;
        
        //Alle Label inside "panel_def"
        panel_def.setLayout(null);    
        Font F = new Font("Serif", Font.BOLD, 18);
        Font f = new Font("Serif", Font.BOLD, 14);
        JLabel def = new JLabel("DEFINITIONS");
        JLabel h0  = new JLabel("( let  j = 0, 1, , ..., 17  and  i = 1, 2, ..., 64 )");
        JLabel h1  = new JLabel("m[j] := Part of the INPUT p's ROUNDCIPHER after j (resp. j-1) rounds");
        //JLabel h2  = new JLabel("DES( i ) := DES(k, p+e_i)           DES( 0 ) := DES(k, p)");
        JLabel h2  = new JLabel("DES(0) := DES(k, p)           DES(i) := DES(k, p+e_i)          e_i := i-th unit vector");
        JLabel h3  = new JLabel("{ INPUT, OUTPUT } := { Plaintext p, Ciphertext c }");
        JLabel h4  = new JLabel("k(z) := a special DES-Key  (defined by z)");
        JLabel h5  = new JLabel("K_j := Roundkey No. j");
               
        JLabel bigDES_1 = new JLabel("Data Encryption");
        Font smallSize  = new Font("Times New Roman", Font.BOLD, 40);
        bigDES_1.setFont(smallSize);
        bigDES_1.setForeground(Color.red);
        bigDES_1.setBounds(30,-20,400,150);
        panel_def.add(bigDES_1);
        
        //panel_def
        JLabel bigDES_11 = new JLabel("Standard  (DES)");
        bigDES_11.setFont(smallSize);  
        bigDES_11.setForeground(Color.red);
        bigDES_11.setBounds(30,30,400,150);
        panel_def.add(bigDES_11);
        
        //Alle Label inside "panel_ENCRYPT"
        JLabel bigDES_2 = new JLabel("DES");
        Font bigSize    = new Font("Times New Roman", Font.BOLD, 100);
        bigDES_2.setFont(bigSize);  
        bigDES_2.setForeground(Color.red);
        bigDES_2.setBounds(30,10,400,150);
        panel_ENCRYPT.add(bigDES_2);//
        
        //Alle Label inside "panel_dist_matrices"
        JLabel hamming_1  = new JLabel("A, B visualize Hamming distances between");
        JLabel hamming_2  = new JLabel("DES(k, INPUT_1)   and");
        JLabel hamming_3  = new JLabel("DES(k, INPUT_2)");
        JLabel hamming_4  = new JLabel("where   INPUT_1, INPUT_2");
        JLabel hamming_5  = new JLabel("have a Hamming distance");
        JLabel hamming_6  = new JLabel("of 1 (for A) and 2 (for B).");
        JLabel big_A      = new JLabel("( A[i,j] ) =");
        JLabel big_B      = new JLabel("= ( B[i,j] )");
        JLabel matrix_L   = new JLabel("A[i,j] = dist ( DES(0), DES(8[i-1] + j) )");
        JLabel matrix_R   = new JLabel("B[i,j] = dist ( DES(8[i-1]+j-1), DES(8[i-1]+j) )");
        JLabel def_row_0  = new JLabel("DES(0) := DES(k, p)");
        JLabel def_row_i  = new JLabel("DES(i)  := DES(k, p+e_i)");
        JLabel input_L    = new JLabel("dist (p, p+e_i) = 1");
        JLabel input_R    = new JLabel("dist (p+e_i, p+e_[i+1]) = 2");
        JLabel one_half   = new JLabel("32/64 = 1/2");
               
        Font SmallSize  = new Font("Times New Roman", Font.BOLD, 15);
        Font MediumSize = new Font("Times New Roman", Font.BOLD, 20);
        Font BigSize    = new Font("Times New Roman", Font.BOLD, 30);

        matrix_L.setFont(SmallSize); 
        matrix_R.setFont(SmallSize);
        def_row_0.setFont(SmallSize);
        def_row_i.setFont(SmallSize);
        input_L.setFont(SmallSize);
        input_R.setFont(SmallSize);
        one_half.setFont(BigSize);
        big_A.setFont(BigSize);
        big_B.setFont(BigSize);
        hamming_1.setFont(MediumSize);
        hamming_2.setFont(MediumSize);
        hamming_3.setFont(MediumSize);
        hamming_4.setFont(MediumSize);
        hamming_5.setFont(MediumSize);
        hamming_6.setFont(MediumSize);
        
        big_A.setForeground(Color.blue);
        big_B.setForeground(Color.blue);
        matrix_L.setForeground(Color.blue);
        matrix_R.setForeground(Color.blue);
        def_row_0.setForeground(Color.red);
        def_row_i.setForeground(Color.red);
        input_L.setForeground(Color.blue);
        input_R.setForeground(Color.blue);
        one_half.setForeground(Color.red);
        hamming_1.setForeground(Color.red);
        hamming_2.setForeground(Color.red);
        hamming_3.setForeground(Color.red);
        hamming_4.setForeground(Color.red);
        hamming_5.setForeground(Color.red);
        hamming_6.setForeground(Color.red);
        
        big_A.setBounds(305,60,400,150);
        big_B.setBounds(830,60,400,150);
        matrix_L.setBounds(350,140,400,150);
        matrix_R.setBounds(670,140,400,150);
        input_L.setBounds(350,170,400,150);
        input_R.setBounds(670,170,400,150);
        def_row_0.setBounds(440,210,400,150);
        def_row_i.setBounds(440,230,400,150);
        one_half.setBounds(30,225,400,150);
        hamming_1.setBounds(25,0,400,150);
        hamming_2.setBounds(25,40,400,150);
        hamming_3.setBounds(25,70,400,150);
        hamming_4.setBounds(25,110,400,150);
        hamming_5.setBounds(25,140,400,150);
        hamming_6.setBounds(25,170,400,150);
        
        panel_dist_matrices.add(big_A);
        panel_dist_matrices.add(big_B);
        panel_dist_matrices.add(matrix_L);
        panel_dist_matrices.add(matrix_R);
        //panel_dist_matrices.add(def_row_0);
        //panel_dist_matrices.add(def_row_i);
        panel_dist_matrices.add(input_L);
        panel_dist_matrices.add(input_R);
        panel_dist_matrices.add(hamming_1);
        panel_dist_matrices.add(hamming_2);
        panel_dist_matrices.add(hamming_3);
        panel_dist_matrices.add(hamming_4);
        panel_dist_matrices.add(hamming_5);
        panel_dist_matrices.add(hamming_6);
        //panel_dist_matrices.add(one_half);
        
        //Alle Label in "panel_ENCRYPT"
        JLabel bigDES_3 = new JLabel("DES");                                   
        Font middleSize = new Font("Times New Roman", Font.BOLD, 80);
        bigDES_3.setFont(middleSize);  
        bigDES_3.setForeground(Color.red);
        bigDES_3.setBounds(30,-30,400,150);
        panel_ANTI_FIXED_PTS.add(bigDES_3);
  
      
        //Alle Label inside "panel_DKA" ********************* DKA ****************** DKA ******************** DKA
        panel_DKA.setLayout(null);    
        output8.setTableHeader(null);                                           // Table output8
        output8.setBounds(40,70,width-600,height2-86);      
        output8.setAutoResizeMode(JTable.AUTO_RESIZE_OFF); 
        panel_DKA.add(output8);
               
        Color colour = new Color(210,253,115);
        header6.setBounds(40,54,width-600,16);                                  // Header der Table
        for(int n=0; n<8; n++)
             header6.setValueAt("         S" + Integer.toString(n+1) + "  ",0,n);
             //header.SetBackground(Color.green);
        panel_DKA.add(header6); 
        
        //Color c3 = new Color(210,253,115);
        TableColumn tc_DKA [] = new TableColumn[8];
        for(int k=0; k<tc_DKA.length; k++)
        {
             tc_DKA[k] = output8.getColumnModel().getColumn(k);
             tc_DKA[k].setPreferredWidth(1);
        }       
        
        JLabel DKA_input       = new JLabel("INPUT = DELTA_p");
        JLabel DKA_16hexdigits = new JLabel("(16 Hex-digits)");
        JLabel DKA_random_k    = new JLabel("k");
        JLabel DKA_random_m    = new JLabel("p");
        
        
        DKA_input.setFont(f);
        DKA_16hexdigits.setFont(f);
        DKA_random_k.setFont(f);
        DKA_random_m.setFont(f);
        DKA_input.setForeground(Color.blue);                                    // Label DELTA_m
        DKA_16hexdigits.setForeground(Color.blue);
        DKA_random_k.setForeground(Color.red);
        DKA_random_m.setForeground(Color.red);
        DKA_input.setBounds(680,45,250,25);
        DKA_16hexdigits.setBounds(860,67,250,25);
        DKA_random_k.setBounds(670,130,50,25);
        DKA_random_m.setBounds(855,130,50,25);
        panel_DKA.add(DKA_input);
        panel_DKA.add(DKA_16hexdigits);
        panel_DKA.add(DKA_random_k);
        panel_DKA.add(DKA_random_m);
        
        in_dka.setBounds(680,70,175,25);                                       // Field INPUT m
        //Color c3 = new Color(210,253,115);  //lemon
        in_dka.setForeground(Color.black);
        panel_DKA.add(in_dka);
        
        random_k_dka.setBounds(680,130,152,25);                                // Field RANDOM KEY
        //Color c3 = new Color(210,253,115);  //lemon
        random_k_dka.setForeground(Color.RED);
        random_k_dka.setEnabled(false);
        panel_DKA.add(random_k_dka);
        
        random_m_dka.setBounds(864,130,159,25);                                // Field RANDOM INPUT
        //Color c3 = new Color(210,253,115);  //lemon
        random_m_dka.setForeground(Color.RED);
        random_m_dka.setEnabled(false);
        panel_DKA.add(random_m_dka);
        
        random_k_dka.setText("Random Key (System)");                            //ESSLINGER
        random_m_dka.setText("Random Input (System)");                          //ESSLINGER
       
        in3_action.setForeground(Color.red);                                    // ACTION-BUTTON              
        in3_action.setBounds(680,100,180,25);
        panel_DKA.add(in3_action);
        
        JLabel DKA_diff_Crypt_up   = new JLabel("Differential");                 
        JLabel DKA_diff_Crypt_down = new JLabel("Cryptanalysis");
        JLabel DKA_diff_Crypt_Random  = new JLabel("( k, p  are randomly chosen )");
        JLabel DKA_diff_Crypt_Random1 = new JLabel("RED cells = ACTIVE S-Boxes");
        JLabel DKA_diff_Crypt_Random2 = new JLabel("(each line reflects 1 round inside DES)");
        DKA_diff_Crypt_up.setFont(smallSize);
        DKA_diff_Crypt_down.setFont(smallSize);
        DKA_diff_Crypt_Random.setFont(F);
        DKA_diff_Crypt_Random1.setFont(F);
        DKA_diff_Crypt_Random2.setFont(F);
        DKA_diff_Crypt_up.setForeground(Color.red);
        DKA_diff_Crypt_down.setForeground(Color.red);
        DKA_diff_Crypt_Random.setForeground(Color.red);
        DKA_diff_Crypt_Random1.setForeground(Color.black);
        DKA_diff_Crypt_Random2.setForeground(Color.black);
        DKA_diff_Crypt_up.setBounds(680,165,200,30);                            // Label "Diff. Cryptanalysis"
        DKA_diff_Crypt_down.setBounds(680,190,250,50);
        DKA_diff_Crypt_Random.setBounds(680,240,250,30);
        DKA_diff_Crypt_Random1.setBounds(680,270,270,30);
        DKA_diff_Crypt_Random2.setBounds(680,300,300,30);
        panel_DKA.add(DKA_diff_Crypt_up);
        panel_DKA.add(DKA_diff_Crypt_down);
        panel_DKA.add(DKA_diff_Crypt_Random);
        panel_DKA.add(DKA_diff_Crypt_Random1);
        panel_DKA.add(DKA_diff_Crypt_Random2);
        in3_action.addActionListener(this);
        
        //********************* DKA *************** DKA ************ DKA *************** DKA ****************
        
        //Inside "panel_def"
        def.setFont(F);
        def.setForeground(Color.blue);
        def.setBackground(Color.yellow);
        def.setBounds(400,40,400,30);
        panel_def.add(def);
        
        //Einsetzen der Labels in Panel 1   +++   POSITION/GROESSE der Labels definieren
        h0.setFont(f);
        h0.setBounds(560,40,400,30);
        h0.setForeground(Color.blue);
        panel_def.add(h0);
        h1.setFont(f);
        h1.setBounds(400,80,460,30);
        panel_def.add(h1);
        h2.setFont(f);
        h2.setBounds(400,120,800,30);
        panel_def.add(h2);
        h3.setFont(f);
        h3.setBounds(400,160,400,30);
        panel_def.add(h3);
        h4.setFont(f);
        h4.setBounds(400,200,300,30);
        panel_def.add(h4);
        h5.setBounds(400,240,300,30);
        h5.setFont(f);
        panel_def.add(h5);
    
        //Einsetzen der Label in Panel 3   +++   POSITION/GROESSE der Labels definieren
        panel_m.setLayout(null);        
        header1.setBounds(60,20,width-300,16);
        panel_m.add(header1);
        
        JLabel topic_panel_m = new JLabel("The rows  m[0], . . . , m[17]  are the components of the Roundciphers  (m[0], m[1]), . . . , (m[16], m[17])."); //ESSLINGER
        topic_panel_m.setFont(f);
        topic_panel_m.setForeground(Color.blue);
        topic_panel_m.setBounds(133,338,650,25);
        panel_m.add(topic_panel_m);
        
       
        //Koordinaten/Groesse von m[0]...m[17] definieren
        //Einsetzen von m[0]...m[17] in Panel 3
        //Einfuegen von m[0]...m[17] in ee Scroll-Pane jsp1
        output1.setBounds(60,36,width-300,height2);
        JScrollPane jsp1 = new JScrollPane(output1);
        panel_m.add(output1); 
        
        
        //Settings von Spalte 0 und 33 in JTable "header1"  (= m[0]...m[17])                    
        TableColumn header1_t2 = header1.getColumnModel().getColumn(0);
                               header1_t2.setPreferredWidth(122);
        TableColumn header2_t2 = header1.getColumnModel().getColumn(9);
                               header2_t2.setPreferredWidth(128);
        
        
        //Settings von Spalte 0 und 33 in JTable "output1"  (= m[0]...m[17])
        TableColumn column1_t2 = output1.getColumnModel().getColumn(0);
                              column1_t2.setPreferredWidth(1300);
        TableColumn column2_t2 = output1.getColumnModel().getColumn(33);
                              column2_t2.setPreferredWidth(1300);
                                            
      
        //Alles inside "panel_DES"
        panel_DES.setLayout(null);        
        output2.setTableHeader(null);
        output2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
       
        //Verbinden der DES_table mit einer JScrollPane und dann beids Einfuegen in "panel_DES"
        JScrollPane jsp2 = new JScrollPane(output2);
        jsp2.setBounds(10,5,width-120,height2);
        panel_DES.add(jsp2);
        
        //Linke Spalte in "panel_DES" (Panel 4)
        TableColumn column1_t3 = output2.getColumnModel().getColumn(0);
                                 column1_t3.setPreferredWidth(60);
        
        //Settings der 64 Spalten zwi aeusserster li/re Spalte im "panel_DES" (Panel 4)
        TableColumn tc [] = new TableColumn[64];
        for(int k=0; k<tc.length; k++)
        {
                tc[k] = output2.getColumnModel().getColumn(k+1);
                        tc[k].setPreferredWidth(5);
        }
               
        TableColumn dist = output2.getColumnModel().getColumn(65);
                           dist.setPreferredWidth(60);
        
        JLabel topic_panel_DES = new JLabel("DES(k,p) and DES(i)   in binary notation.   The most right cells indicate the hamming distance between DES(k,p) and DES(i).  They define matrix A (see \"p � 32/64\").");   //ESSLINGER
        topic_panel_DES.setFont(f);
        topic_panel_DES.setForeground(Color.blue);
        topic_panel_DES.setBounds(20,350,1100,25);
        //topic_panel_roundkeys2.setBounds(65,373,700,25);
        panel_DES.add(topic_panel_DES);

        // *********************************************************************************
        
        //panel_dist_matrices
        panel_dist_matrices.setLayout(null);
        
        //Einsetzen der JTables "output 6,7" in das Panel "panel_dist_matrices"
        output6.setBounds(440,70,155,128);
        panel_dist_matrices.add(output6);
        
        output7.setBounds(670,70,155,128);
        panel_dist_matrices.add(output7);

        // ************************************************************************************     
                
        //Alles von "Panel_Roundkeys"  (Panel 6)
        panel_roundkeys.setLayout(null);        
        header3.setBounds(60,27,width-300,16);
        panel_roundkeys.add(header3);
        
        JLabel topic_panel_roundkeys1 = new JLabel("The rows  K_1, . . . , K_16  represent DES' roundkeys. Each roundkey K_j depends on KEY k.");   //ESSLINGER
        topic_panel_roundkeys1.setFont(f);
        topic_panel_roundkeys1.setForeground(Color.blue);
        topic_panel_roundkeys1.setBounds(65,323,600,25);
        panel_roundkeys.add(topic_panel_roundkeys1);
        
        JLabel topic_panel_roundkeys2 = new JLabel("If k = k(z), then in each of the 12 blocks [(1,4(j-1)+1); (16,4j)] (j = 1, ..., 12) of size 16 x 4, horizontal quadrupels with the same color are the same.");   //ESSLINGER
        topic_panel_roundkeys2.setFont(f);
        topic_panel_roundkeys2.setForeground(Color.blue);
        topic_panel_roundkeys2.setBounds(65,345,900,25);
        panel_roundkeys.add(topic_panel_roundkeys2);
        
        //Verbinden der table_roundkeys mit einer JScrollPane und zusammen Einfuegen in "panel_roundkeys"
        output3.setBounds(60,46,width-300,height2);
        JScrollPane jsp3 = new JScrollPane(output3);
        panel_roundkeys.add(output3);
        
        //Settings der aeussersten li/re Spalte in Table der Roundkeys K_i
        TableColumn colum3_t2 = output3.getColumnModel().getColumn(0);
                                colum3_t2.setPreferredWidth(1000);
        TableColumn colum4_t2 = output3.getColumnModel().getColumn(49);
                                colum4_t2.setPreferredWidth(1000);
        TableColumn c1 = header3.getColumnModel().getColumn(0);
                         c1.setPreferredWidth(49);
        TableColumn c14 = header3.getColumnModel().getColumn(13);
                          c14.setPreferredWidth(44);
        
        //*************************************************************************************8
        
        //Verbinden der CD_table mit einer JScrollPane und zusammen Einfuegen in "panel_CD_matrix"
        panel_CD_matrix.setLayout(null);        
        output4.setTableHeader(null);
        output4.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
       
        JScrollPane jsp6 = new JScrollPane(output4);
        jsp6.setBounds(250,0,width-700,height2);
        panel_CD_matrix.add(jsp6);
        
        //Settings aller Spalten in der CD_Matrix
        TableColumn fcol = output4.getColumnModel().getColumn(0);
        fcol.setPreferredWidth(60);
        
        TableColumn tco1 [] = new TableColumn[28];
        for(int k=0; k<tco1.length; k++)
        {
                tco1[k] = output4.getColumnModel().getColumn(k+1);
                tco1[k].setPreferredWidth(10);
        }
      

        // Panel 5 is unused (use = later)
        panel_DKA.setLayout(null);        
    
        // Verbinden von m[8]--m[17] mit panel_ANTI_FIXED_PTS   = Panel 4
        header5.setBounds(40,150,width-300,16);
        panel_ANTI_FIXED_PTS.add(header5);
        
        output5.setBounds(40,165,width-300,height2-170);
        panel_ANTI_FIXED_PTS.add(output5);
        
        JLabel topic_panel_AFP = new JLabel("For a documentation, click \"Help\" and read on p. 2 the paragraph about \"Fixed Points\"."); //ESSLINGER
        topic_panel_AFP.setFont(f);
        topic_panel_AFP.setForeground(Color.blue);
        topic_panel_AFP.setBounds(115,338,650,25);
        panel_ANTI_FIXED_PTS.add(topic_panel_AFP);
        
        
        //*****************************************************
        
        
        //Settings der Spaltenbreite von Table "output5"   (= m[8]--m[17])
        TableColumn c8 = output5.getColumnModel().getColumn(0);
                         c8.setPreferredWidth(1300);
        TableColumn c9 = output5.getColumnModel().getColumn(33);
                         c9.setPreferredWidth(1300);
        TableColumn c10 = header5.getColumnModel().getColumn(0);
                          c10.setPreferredWidth(122);
        TableColumn c11 = header5.getColumnModel().getColumn(9);
                          c11.setPreferredWidth(128);
        
        
        //Def. Button Group for "EN-/DECRYPT" (genau 1 Selektion ist in Button Group moeglich)
        panel_ENCRYPT.setLayout(null);  
        ButtonGroup crypts = new ButtonGroup();
        crypts.add(encrypt);
        crypts.add(decrypt);
        encrypt.setActionCommand("ENCRYPT");
        decrypt.setActionCommand("DECRYPT");
        encrypt.setSelected(true);           // default
        
        //Einsetzen der Buttons "encrypt/decrypt" in Panel 1 (= panel_ENCRYPT)
        encrypt.setBounds(420,20,100,25);
        panel_ENCRYPT.add(encrypt);
        decrypt.setBounds(530,20,100,25);
        panel_ENCRYPT.add(decrypt);
        
        //Button Group der 8 Keys
        ButtonGroup Ks = new ButtonGroup(); 
        Ks.add(k0);
        Ks.add(k3);
        Ks.add(k5);
        Ks.add(k6);
        Ks.add(k9);
        Ks.add(k10);
        Ks.add(k12);
        Ks.add(k15);
        Ks.add(khex);
        
        //Definition von Action-Commands
        k0.setActionCommand("k0");
        k3.setActionCommand("k3");
        k5.setActionCommand("k5");
        k6.setActionCommand("k6");
        k9.setActionCommand("k9");
        k10.setActionCommand("k10");
        k12.setActionCommand("k12");
        k15.setActionCommand("k15");
        khex.setActionCommand("khex");
        
        //Define/add Label in Panel 2  (= panel_ENCRYPT)
        JLabel key = new JLabel("KEY");
        key.setBounds(425,55,70,25);
        key.setForeground(Color.red);
        key.setFont(f);
        int dismissDelay = ToolTipManager.sharedInstance().getDismissDelay();
        dismissDelay = Integer.MAX_VALUE;
        ToolTipManager.sharedInstance().setDismissDelay(dismissDelay);
        
        key.setToolTipText("<html>" + "Either select one of k(0), k(3), . . . , k(15) OR enter KEY k manually." + "</html>");  //TO BE CHECKED // ESSLINGER
        //String pic_name = "../wolfgangbaltes/software_march09/camel.jpg";
        //key.setToolTipText("<html> Laundry Picture <img src=" + pic_name + "></html>");

        panel_ENCRYPT.add(key);
        
        //Einsetzen aller Key-Buttons in Panel 2 (= panel_ENCRYPT)
        k0.setBounds(420,75,60,25);
        k0.setToolTipText("<html>" + "<b>" + "k(0) = 0101 0101 0101 0101  (16 Hex-digits)" + "</html>");
        panel_ENCRYPT.add(k0);
        k3.setBounds(500,75,60,25);
        k3.setToolTipText("<html>" + "<b>" + "k(3) = 01FE 01FE 01FE 01FE  (16 Hex-digits)" + "</html>");
        panel_ENCRYPT.add(k3);
        k5.setBounds(420,100,60,25);
        k5.setToolTipText("<html>" + "<b>" + "k(5) = 1F1F 1F1F 0E0E 0E0E  (16 Hex-digits)" + "</html>");
        panel_ENCRYPT.add(k5);
        k6.setBounds(500,100,60,25);
        k6.setToolTipText("<html>" + "<b>" + "k(6) = 1FE0 1FE0 1FE0 1FE0  (16 Hex-digits)" + "</html>");
        panel_ENCRYPT.add(k6);
        k10.setBounds(420,125,70,25);
        k10.setToolTipText("<html>" + "<b>" + "k(10) = E0E0 E0E0 F1F1 F1F1  (16 Hex-digits)" + "</html>");
        panel_ENCRYPT.add(k10);
        k9.setBounds(500,125,60,25);
        k9.setToolTipText("<html>" + "<b>" + "k(9) = E01F E01F F10E F10E  (16 Hex-digits)" + "</html>");
        panel_ENCRYPT.add(k9);
        k15.setBounds(420,150,70,25);
        k15.setToolTipText("<html>" + "<b>" + "k(15) = FEFE FEFE FEFE FEFE  (16 Hex-digits)" + "</html>");
        panel_ENCRYPT.add(k15);
        k12.setBounds(500,150,70,25);
        k12.setToolTipText("<html>" + "<b>" + "k(12) = FE01 FE01 FE01 FE01  (16 Hex-digits)" + "</html>");
        /*
        k12.setToolTipText("<html><body>" + 
                           "<p><font size=\"5\" face=\"arial\" color=\"red\">" + "First paragraph" + "</font></p>"
                           +"<p>Second paragraph </p>"
                           + "<img border=\"1\" src=\"norway.jpg\" width=\"30\" height=\"24\" />"
                           + "</body></html>");
         */
        panel_ENCRYPT.add(k12);
        khex.setBounds(420,175,23,25);
        khex.setSelected(true);
        panel_ENCRYPT.add(khex);
        //MANUAL KEY Panel 2
        key_hex.setBounds(445,175,175,25);  
        panel_ENCRYPT.add(key_hex);
        //add label MANUAL Key  (PANEL 2)   
        JLabel hex_radio = new JLabel("INPUT = k = MANUAL KEY (16 Hex-digits)");
        hex_radio.setBounds(450,197,280,25);
        hex_radio.setForeground(Color.blue);
        hex_radio.setFont(f);
        panel_ENCRYPT.add(hex_radio);
        
        //Einsetzen/Lokalisieren aller Labels/TextFields in Panel 2 (= panel_ENCRYPT)
        JLabel key_selected = new JLabel("Selected key (16 Hex-digits)");
        key_selected.setBounds(700,40,180,25);
        key_selected.setForeground(Color.blue);
        key_selected.setFont(f);
        //panel_ENCRYPT.add(key_selected);
        
                
        JLabel ip = new JLabel("INPUT = p = plaintext (16 Hex-digits)");
        ip.setBounds(700,80,240,25);
        ip.setForeground(Color.blue);
        ip.setFont(f);
        panel_ENCRYPT.add(ip);
        
        
        //INPUT Panel 2
        in_hex.setBounds(700,105,175,25);       
        panel_ENCRYPT.add(in_hex);
        
        //OUTPUT Panel 2
        out_hex.setBounds(700,133,175,25);     
        //out_hex.setForeground(Color.red);
        out_hex.setEnabled(false);
        out_hex.setForeground(Color.red);
        panel_ENCRYPT.add(out_hex);

        //out_bin.setBounds(445,240,530,25);    
        //out_hex.setForeground(Color.red);
        out_bin.setBounds(400,240,600,25);
        out_bin.setEnabled(false);
        out_bin.setForeground(Color.red);   
        panel_ENCRYPT.add(out_bin);           //ESSLINGER
        
        
        
        //Label "OUTPUT (16 hex-digits)" in  "panel_ENCRYPT"
        JLabel op = new JLabel("OUTPUT = c = ciphertext (16 Hex-digits)");
        op.setBounds(700,157,260,25);
        op.setForeground(Color.red);
        op.setFont(f);
        op.setToolTipText("The Hex-notation of c equals DES(K,p) in the top row of the panel \"DES(k, p+e_i)\" ");
        panel_ENCRYPT.add(op);
        
        //JLabel op_bin = new JLabel("OUTPUT = c = ciphertext (64 bit)"); //ESSLINGER
        JLabel op_bin = new JLabel("OUTPUT in binary notation (64 bit)"); //ESSLINGER
        op_bin.setBounds(765,217,570,25);
        op_bin.setForeground(Color.red);
        //op_bin.setEnabled(true);
        op_bin.setFont(f);
        op_bin.setToolTipText("Above see the Hex-notation of c with 64 bits.");
        panel_ENCRYPT.add(op_bin);            //ESSLINGER
        
        //Einsetzen/Lokalisieren des ActionButtons "in1_action" in Panel 2 (= panel_ENCRYPT)    //ESSLINGER
        in1_action.setBounds(420,290,570,25);
        in1_action.setBackground(Color.black);
        in1_action.setForeground(Color.red);
        //in1_action.setForeground(new Color(30,249,254));
        //in1_action.setEnabled(false);
        panel_ENCRYPT.add(in1_action);
        
        //********** ANTI-/FIXED POINTS (Panel 7 = "panel_ANTI_FIXED_PTS") ******************************
        panel_ANTI_FIXED_PTS.setLayout(null);  
        ButtonGroup fafp = new ButtonGroup(); //fafp = Fixed-/AntiFixed Point
        fafp.add(fixed);
        fafp.add(anti_fixed);
        fixed.setActionCommand("FIXED");
        anti_fixed.setActionCommand("ANTI_FIXED");
        fixed.setSelected(true);                   // default
        fixed.addActionListener(this);             // ActionListener aktivieren
        anti_fixed.addActionListener(this);
        
        fixed.setBounds(420-50,20,120,25);
        panel_ANTI_FIXED_PTS.add(fixed);
        anti_fixed.setBounds(510,20,155,25);
        panel_ANTI_FIXED_PTS.add(anti_fixed);
        
        //2 Button Groups fuer je 4 Keys im "panel_ANTI_FIXED_PTS"
        ButtonGroup fafs1 = new ButtonGroup(); //fuer k(0), k(5), k(10), k(15)
        ButtonGroup fafs2 = new ButtonGroup(); //fuer k(3), k(6), k(9),  k(12)
        fafs1.add(fk0);
        fafs1.add(fk5);
        fafs1.add(fk10);
        fafs1.add(fk15);
        
        fafs2.add(fk3);
        fafs2.add(fk6);
        fafs2.add(fk9);
        fafs2.add(fk12);
        
        fk3.setEnabled(false);
        fk6.setEnabled(false);
        fk9.setEnabled(false);
        fk12.setEnabled(false);
        
        fk0.setActionCommand("k0");
        fk3.setActionCommand("k3");
        fk5.setActionCommand("k5");
        fk6.setActionCommand("k6");
        fk9.setActionCommand("k9");
        fk10.setActionCommand("k10");
        fk12.setActionCommand("k12");
        fk15.setActionCommand("k15");
        //khex.setActionCommand("khex");
        
        fk0.setToolTipText("<html>" + "<b>" + "k(0) = 0101 0101 0101 0101  (16 Hex-digits)" + "</html>");
        fk3.setToolTipText("<html>" + "<b>" + "k(3) = 01FE 01FE 01FE 01FE  (16 Hex-digits)" + "</html>");
        fk5.setToolTipText("<html>" + "<b>" + "k(5) = 1F1F 1F1F 0E0E 0E0E  (16 Hex-digits)" + "</html>");
        fk6.setToolTipText("<html>" + "<b>" + "k(6) = 1FE0 1FE0 1FE0 1FE0  (16 Hex-digits)" + "</html>");
        fk9.setToolTipText("<html>" + "<b>" + "k(9) = E01F E01F F10E F10E  (16 Hex-digits)" + "</html>");
        fk10.setToolTipText("<html>" + "<b>" + "k(10) = E0E0 E0E0 F1F1 F1F1  (16 Hex-digits)" + "</html>");
        fk12.setToolTipText("<html>" + "<b>" + "k(12) = FE01 FE01 FE01 FE01  (16 Hex-digits)" + "</html>");
        fk15.setToolTipText("<html>" + "<b>" + "k(15) = FEFE FEFE FEFE FEFE  (16 Hex-digits)" + "</html>");
        
        
        JLabel target_point  = new JLabel("TARGET");
        target_point.setBounds(425-50,3,100,25);
        target_point.setForeground(Color.red);
        target_point.setFont(f);
        panel_ANTI_FIXED_PTS.add(target_point);
        
        JLabel fkey = new JLabel("KEY");
        fkey.setBounds(425-50,55,70,25);
        fkey.setForeground(Color.red);
        fkey.setFont(f);
        panel_ANTI_FIXED_PTS.add(fkey);
        
        fk0.setBounds(420-50,75,60,25);
        fk0.setSelected(true);          //default
        panel_ANTI_FIXED_PTS.add(fk0);
        
        fk3.setBounds(510,75,60,25);
        fk3.setSelected(true);          //default
        panel_ANTI_FIXED_PTS.add(fk3);
        
        fk5.setBounds(420-50,100,60,25);
        panel_ANTI_FIXED_PTS.add(fk5);
        
        fk6.setBounds(510,100,60,25);
        panel_ANTI_FIXED_PTS.add(fk6);
        
        fk10.setBounds(420,125-50,70,25);
        panel_ANTI_FIXED_PTS.add(fk10);
        
        fk9.setBounds(510+50,125-50,60,25);
        panel_ANTI_FIXED_PTS.add(fk9);
        
        fk15.setBounds(420,150-50,70,25);
        panel_ANTI_FIXED_PTS.add(fk15);
        
        fk12.setBounds(510+50,150-50,70,25);
        panel_ANTI_FIXED_PTS.add(fk12);
        
        //Einsetzen des ActionButtons "in2_action" in Panel 7
        in2_action.setBounds(40,95,250,25);
        in2_action.setForeground(Color.red);
        /*in2_action.setToolTipText("<html><body>"
                                  + "<p><font size=\"5\" face=\"times new roman\" color=\"green\">"
                                  + "(1) Theory tells for FIXED-PTS: &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
                                  + "m[0]=m[17], m[1]=m[16], ..., m[8]=m[9]."
                                  + "</font></p>"
                                  + "<p> </p>"
                                  + "<p><font size=\"5\" face=\"times new roman\" color=\"green\">"
                                  + "(2) Theory tells for ANTI-FIXED-PTS:&nbsp;&nbsp;  m[0]=1^m[17],  m[1]=1^m[16], ...,  m[8]=1^m[9]."
                                  + "</font></p>"
                                  + "<p> </p>"
                                  + "<p><font size=\"5\" face=\"times new roman\" color=\"blue\">"
                                  + "(3) Hence, to know all (m[j]), it is enough to display only m[8], . . ., m[17].</p>"
                                  + "<p><font size=\"5\" face=\"times new roman\" color=\"blue\">"
                                  + "To see all m[j], copy KEY and OUTPUT into the panel \"Key/Plaintext\" and then evaluate."
                                  + "</font></p>"
                                  + "</body></html>");
         */
        panel_ANTI_FIXED_PTS.add(in2_action);
        
        
        //Einsetzen aller Input-Labels in "panel_ANTI_FIXED_PTS"
        JLabel fip = new JLabel("INPUT = m[8]        (32 bit)");
        fip.setBounds(710,28,180,25); // fip = INPUT-Label im Panel "panel_ANTI_FIXED_PTS"
        fip.setForeground(Color.blue);
        fip.setFont(f);
        panel_ANTI_FIXED_PTS.add(fip);
        
        //Einsetzen des TextFeldes "inf_bin" (= INPUT m[8]) in "panel_ANTI_FIXED_PTS"
        //inf_bin.setBounds(710,53,230,25);
        inf_bin.setBounds(710,53,272,25);
        panel_ANTI_FIXED_PTS.add(inf_bin);
        
        //Einsetzen des TextFeldes "outf_hex" (= ANTI-/FIXED POINT) in "panel_ANTI_FIXED_PTS"
        outf_hex.setBounds(710,123-44,152,25);
        //outf_hex.setEnabled(false);
        outf_hex.setForeground(Color.red);
        panel_ANTI_FIXED_PTS.add(outf_hex);
        
        //Einsetzen des Labels in "panel_ANTI_FIXED_PTS"
        JLabel fop = new JLabel("OUTPUT = ANTI-/FIXED POINT (16 Hex-digits)");
        fop.setBounds(710,148-44,400,25);  // fip = OUTPUT-Label im Panel "panel_ANTI_FIXED_PTS"
        fop.setForeground(Color.red);
        fop.setFont(f);
        panel_ANTI_FIXED_PTS.add(fop);
        
        
        //Array aller Panels  ***************************************************************************************************
        JPanel  panels[] = {  
           panel_def, panel_ENCRYPT, panel_m, panel_DES, panel_dist_matrices, panel_roundkeys, panel_CD_matrix, panel_ANTI_FIXED_PTS,
                panel_DKA};

        //JLabel topic_panel_CD = new JLabel("Rows  C[j], D[j]  are generated from key k.  A permutet substring of (C[j],D[j])  defines the roundkey K_j.");   
        //ESSLINGER
        JLabel topic_panel_CD = new JLabel("(C[0], D[0]) depends on KEY k and generates (C[j], D[j]) by a circular shift. Roundkey K_j is an ordered subset of (C[j], D[j]).");   
        //ESSLINGER
        topic_panel_CD.setFont(f);
        topic_panel_CD.setForeground(Color.blue);
        topic_panel_CD.setBounds(250,353,800,25);
        //topic_panel_roundkeys2.setBounds(250,353,700,25);
        panel_CD_matrix.add(topic_panel_CD);
        
        
        JLabel topic_panel_DKA = new JLabel("For a documentation, read p. 2, 3 in \"Help\"."); //ESSLINGER
        topic_panel_DKA.setFont(f);
        topic_panel_DKA.setForeground(Color.blue);
        topic_panel_DKA.setBounds(685,338,650,25);
        panel_DKA.add(topic_panel_DKA);        
        // ************************************************************************************************************************
        
        tabbedPane = new JTabbedPane(JTabbedPane.BOTTOM);
        
        //    Texts + Panels + Tips  in korrekter Ordnung miteinander verbinden und dann einfuegen
        for(int k=0; k<panels.length; k++)
        {
            tabbedPane.addTab(texts[k], null, panels[k], tips[k]);
        }

        
        int m;  //Beschrifte den Header in "m[0]->m[17]"
        for(m=0; m<9; m++)
        {
             header1.setValueAt("           " + Integer.toString(4*m+4),0,m+1);   //Zeile 0 und Spalte m+1        
        }
        header1.setValueAt("    DIST( m[j-1], m[j] )",0,m); // most re Spalte in Zeile 0 beschriften
        
        
        int a;  //Header beschriften in "m[8]->m[17]"
        for(a=0; a<9; a++)
        {
             header5.setValueAt("           " + Integer.toString(4*a+4),0,a+1);
        }
        //Beschrifte most re Spalte in Zeile 0
        header5.setValueAt("    DIST( m[j-1], m[j] )",0,a); //*****************************
        
        
        int n;  //Header beschriften in "DES(k, p+e_i)"
        for(n=0; n<17; n++)
        {
             header2.setValueAt("        " + Integer.toString(4*n+4),0,n+1);
        }
        //Beschrifte most re Spalte UND Zeile 0 in header2
        header2.setValueAt("dist(6)",0,n); 
        
        
        //Header beschriften in "K_1->K_16"
        for(n=0; n<13; n++)
        {
             header3.setValueAt("        " + Integer.toString(4*n+4),0,n+1);
        }
        //Beschrifte most re Spalte mit leerem String  in header3
        header3.setValueAt("",0,n); 
     
     
        //Beschriften der li Spalte von "m[0]->m[17]" 
        for(int k=0; k<18; k++)
        {
             output1.setValueAt("                  m[" + Integer.toString(k) + "]",k,0);   
        }
        
        for(int k=0; k<10; k++)
        {
             output5.setValueAt("                  m[" + Integer.toString(k+8) + "]",k,0);    
        }
     
     
        //Beschriften der li Spalte inJTable output2 = "DES(k, p+e_i)"
        for(int k=0; k<65; k++)
        {
             if(k==0)
                 output2.setValueAt(" DES(k,p)",k,0); 
             else
                 output2.setValueAt(" DES(" + Integer.toString(k) + ")",k,0);
        }
     
     
        //Beschriften der li Spalte der Roundkeys K_i in JTable "output3"
        for(int k=0; k<16; k++)
        {
             output3.setValueAt("K_" + Integer.toString(k+1),k,0);    
        }
     
     
        //Beschriften der li Spalte der CD_Matrix
        for(int k=0; k<17; k++)
        {
                output4.setValueAt(" C[" + Integer.toString(k) + "]",2*k,0); 
                output4.setValueAt(" D[" + Integer.toString(k) + "]",2*k+1,0);      
        }
        
        in1_action.addActionListener(this);  // "in1_action"  mit ActionListener verbinden
        in2_action.addActionListener(this);  // "in2_action"  mit ActionListener verbinden
        
        getContentPane().add(tabbedPane);  //"tabbedPane" ins AppletPane einfuegen  
        setSize(width-150,height1 + height2); //Size des AppletPane
    } //END OF "init"
    
    
    // table <-- data
    //Zeilenweises Einsetzen von Werten aus "data" in JTable "table", dort in Bereich [(start_row, start_col), (end_row, end_col)]
    //Anpassung der evtl. verschiedenen Indizierungen von "data" und "table"
    public void putValues(JTable table, int start_row,  int end_row, int start_col, int end_col, int data [][])
    {
            int R = start_row; // erste Zeile von JTable, in die ein Wert eingesetzt wird
            int C = start_col; // erste Spalte von JTable, in die ein Wert eingesetzt wird
            for(int r=0; r<data.length; r++)
            {
                    for(int c=0; c<data[0].length; c++)
                    {
                            table.setValueAt( new Integer(data[r][c]), R, C );  // Einfuegen von data[r][c] in table[R][C]
                            C++;
                    }
                    
                    if(R==end_row) //Check:  Ist in JTable die unterste Row (zum Kopieren) bereits erreicht ? ("JA" <=> leave "putValues")
                            break;
                    else
                    {
                            R++;
                            C = start_col; //Starte in der inkrementierten Zeile wieder in 1. Spalte 
                    }
            }      
    }
    
    //table --> scan_data
    //Schreibe Daten von Spalte "col" aus JTable "table" in Vektor "scan_data" als Tupel (w, bool) und markiere dabei durch bool, ob
    //der Wert w in (Spalte, Zeile)=(col,k) bzgl. Vorgaenger (Spalte, Zeile-1) gleich (bool=false) oder verschieden (bool=true) ist.
    //Anhand des Tupels (w,bool) werden spaeter die Eintraege in Spalte "col" rot (bool=true) oder schwarz (bool=false) geschrieben
    public Vector scanCells(int col, int row_start, int row_end, JTable table, Vector scan_data)
    {
            int temp = -1;           
            for(int k=row_start; k<=row_end; k++)
            {
                   if(k==row_start)
                   {   
                       Integer F = (Integer)table.getValueAt(k,col);  // get Integer Object F
                       temp = F.intValue();                           // Ordne temp den primitive value von F zu
                       scan_data.addElement( new Data(k,col,false) ); // false ==> Bei (row_start, col) KEIN Farbwechsel spaeter
                   }                                                  // denn dieser Wert hat keinen Vorgaenger
                   else
                   {
                       Integer A = (Integer)table.getValueAt(k,col);   
                       if(A.intValue()!=temp)     //Verschiedene benachbarte Werte --> true-flag
                       {                          //Gleiche beanchbarte Werte      --> false-flag
                           temp = A.intValue();
                           scan_data.addElement( new Data(k,col,true) ); 
                       }
                       else
                           scan_data.addElement( new Data(k,col,false) );                         
                   }
            }//end of for loop   
            return scan_data;
    }
    
    
    //********* DKA ********** DKA ************* DKA ************
    public Vector scanCells_vsActivity(int col, int row_start, int row_end, JTable table, Vector scan_data)
    {        
            for(int k=row_start; k<=row_end; k++)
            {
                   Integer A = (Integer)table.getValueAt(k,col);   
                   if(A.intValue() == 1)                      
                           scan_data.addElement( new Data(k,col,true) );                        
                       else
                           scan_data.addElement( new Data(k,col,false) );                         
                   
            }//end of for loop 
            return scan_data;
    }    
    //********* DKA ********** DKA ************* DKA ************
    
    //Status: Will man Faerbung bei Changes ? (true, false)=(yes, no), index = Panel-Nr. (0:=Def.-Panel), DESActionType = Encrypt/DeCrypt
    public void doColoring(int start_row, int end_row, int start_col, int end_col, JTable table, boolean status, int index, int DESActionType)
    {                                                                                           // status = Faerbung erwuenscht ?
        Vector scandata = new Vector();                                                         // index  = Nr. des Panels
        for(int col=start_col ; col<=end_col ; col++)
         {    //Scanning aller Columns, Ergebnis wird ueber viele Typen "Data" in den Vector "scandata" geschrieben
              scanCells(col, start_row, end_row, table, scandata);
         }
        
        //DESActionType definiert eine auf-(ENCRYPT)/absteigende(DECRYPT) Ordnung der Roundkeys K_i
        TableCellRenderer tcr = new CustomTableCellRenderer(scandata, status, index, DESActionType);
        
        for(int s_col=start_col; s_col<=end_col; s_col++)
        {  // Registriere jede Spalte bei dem CustomTableCellRenderer
           table.setDefaultRenderer( table.getColumnClass(s_col), tcr );
        }
    }
    
    
    //********* DKA ********** DKA ************* DKA ************
    public void doColoring_vsActivity(int start_row, int end_row, int start_col, int end_col, JTable table, boolean status, int index, int DESActionType)
    {                                                                                           // status = Faerbung erwuenscht ?
        Vector scandata = new Vector();                                                         // index  = Nr. des Panels
        for(int col=start_col ; col<=end_col ; col++)
         {    //Scanning aller Columns, Ergebnis wird ueber viele Typen "Data" in den Vector "scandata" geschrieben
              scanCells_vsActivity(col, start_row, end_row, table, scandata);
         }
        
        //DESActionType definiert eine auf-(ENCRYPT)/absteigende(DECRYPT) Ordnung der Roundkeys K_i
        TableCellRenderer tcr = new CustomTableCellRenderer(scandata, status, index, DESActionType);
        
        for(int s_col=start_col; s_col<=end_col; s_col++)
        {  // Registriere jede Spalte bei dem CustomTableCellRenderer
           table.setDefaultRenderer( table.getColumnClass(s_col), tcr );
        }
    }
    //********* DKA ********** DKA ************* DKA ************

    
    //Check:  "Gesamtlaenge_Entries =? 32"   UND    "Alle Entries aus {0,1} ?"
    public boolean  check_Bin_Input(String input)
    {
           boolean check_status = true;
           if(input.length()==32)
           {
              for(int k=0; k<input.length(); k++)
              {
                   if( !(input.charAt(k)=='0' || input.charAt(k)=='1') ) 
                   {
                           check_status = false;
                           break;
                   }
              }
           }
           else
              check_status = false; 
              
           return check_status;     
    }
    
    //Check:  "Alle Entries aus { 0,1,2,...,9,A,B,C,D,E,F } ?"
    public boolean isHexDigit(String hexDigit)
    {
       char[] hexDigitArray = hexDigit.toCharArray();
       int hexDigitLength = hexDigitArray.length;

       boolean isNotHex;
       for (int i=0; i < hexDigitLength; i++) 
       {  //digit(c,b) gibt den numerischen Wert von c zurueck, der in der Basis b interpretiert wird
          isNotHex = ( Character.digit(hexDigitArray[i], 16) == -1 ); //not -> -1
          if (isNotHex) 
          {
             return false;
          }
       }

       return true;
    }

    //Berechnung von Hamming-Distanzen in DES(k, p+e_i) durch Vgl. von aktueller Zeile mit benachbarter/fixierter Zeile
    //Zum Vgl. wird in A:=dist( DES(0),DES(i) ) eine fixierte Zeile benutzt, dagegen in B:= dist( DES(i-1),DES(i) ) benachbarte Zeilen
    //"isAdjacentComparing" dient als Flag zum Anzeigen ob benachbarte/fixierte Zeile zum Vgl. herangezogen wird
    //"dist_in_col" ist die Nr. der Spalte in "table", in welche die errechnete Distanz geschrieben wird
    public void showDist(int start_col, int end_col, int start_row, int end_row, int dist_in_col, JTable table, boolean isAdjacentComparing)
    {
        int compare_with_this_fixed_row = start_row-1;
            
        for(int r=start_row; r<=end_row; r++)
        {
             int sum=0;
             for(int c=start_col; c<=end_col; c++)
             {
                 if(isAdjacentComparing)
                     sum = sum + ( ((Integer)table.getValueAt(r,c)).intValue() != ((Integer)table.getValueAt(r-1,c)).intValue() ? 1:0 );
                 else
                     sum = sum + (  ((Integer)table.getValueAt(r,c)).intValue() != ((Integer)table.getValueAt(compare_with_this_fixed_row,c)).intValue() ? 1:0);  
             }        
             table.setValueAt(new Integer(sum), r, dist_in_col);  //r = row    dist_in_col = Spalte, in die "sum" geschrieben wird
        }            
    }
  
    
    //Verbindung von ACTIONS und SETTINGS
    public void actionPerformed(ActionEvent ae)
    {
        DESModel DES_C = new DESModel();
        int encrypt_key_selected = -1;// Panel 2
        int fix_key_selected     = -1;// Panel 8
        int action_error         = -1;
        
        //no grouping for the keys in Panel 2
        if(k0.isSelected())   encrypt_key_selected = 0;
        if(k5.isSelected())   encrypt_key_selected = 5;
        if(k10.isSelected())  encrypt_key_selected = 10;
        if(k15.isSelected())  encrypt_key_selected = 15;
        if(k3.isSelected())   encrypt_key_selected = 3;
        if(k6.isSelected())   encrypt_key_selected = 6;
        if(k9.isSelected())   encrypt_key_selected = 9;
        if(k12.isSelected())  encrypt_key_selected = 12;
        if(khex.isSelected()) encrypt_key_selected = 16;
        
        //fixed = RadioButton "FIXED POINT" in Panel 8
        //anti_fixed = RadioButton "ANTI-FIXED POINT" in Panel 8
        if(fixed.isSelected())
        {
                if(fk0.isSelected())  fix_key_selected = 0;
                if(fk5.isSelected())  fix_key_selected = 5;
                if(fk10.isSelected()) fix_key_selected = 10;
                if(fk15.isSelected()) fix_key_selected = 15;
        }
        else if(anti_fixed.isSelected())
        {
                if(fk3.isSelected())  fix_key_selected = 3;
                if(fk6.isSelected())  fix_key_selected = 6;
                if(fk9.isSelected())  fix_key_selected = 9;
                if(fk12.isSelected()) fix_key_selected = 12;
        }
        
        //Setting der Order der Roundkey-Order K1,...,K16  (in most li Spalte in Panel "Roundkeys K_i")
        //encrypt = RadioButton "ENCRYPT"
        if(encrypt.isSelected())
        {       //"ENCRYPT" wurde selektiert -> count-up the Roundkeys
                DES_C.DES_action_type = 0;
                for(int k=0; k<16; k++)
                {
                    output3.setValueAt(" K_" + Integer.toString(k+1),k,0);  
                }
        }
        else
        {       //RadioButton DECRYPT wurde selektiert -> count-down the Roundkeys
                DES_C.DES_action_type = 1;
                for(int k=0; k<16; k++)
                {
                    output3.setValueAt(" K_" + Integer.toString(16-k),k,0);  
                }
        }
        
        boolean fix_status      = fixed.isSelected();
        boolean anti_fix_status = anti_fixed.isSelected();
        
        //******************** ACTION BUTTONS ************* ACTION BUTTONS **************** ACTION BUTTONS ***************
        
        //boolean keys_ok = (key_hex.getText().length()==16) && (in_hex.getText().length() == 16);
        //if(keys_ok)
            //in1_action.setEnabled(true);
        
        //*********** Panel 2,8 Button's action ******** convertHexToBin And Assign As DESkey(String hex)
        if(ae.getSource() == in1_action)// ae = action event  ***  in1_action ist fuer Panel EN-/DECRYPT (Panel 2)
        {
            System.out.println("ACTION 1 = IN PROCESS");
            //System.out.println("Panel 2:      " + encrypt_key_selected + "Crypt action = " + DES_C.DES_action_type);
            boolean flag_key = false; //If "flag_key = true"  ==> Dies induziert Aktionen bzgl. Data in den Tables output1, ..., output4
            //16 = Nr. of the manual key --> Checke den manual key
            if(encrypt_key_selected == 16)
            {
               key_hex.setText(DES_C.cleanTheString(key_hex.getText()));    //ESSLINGER
               if(key_hex.getText().length() == 16) //Korrekte KEY-Laenge
               {
                     if(isHexDigit(key_hex.getText())) //Korrekte KEY-Digits
                     {
                        if(DES_C.check_key_for_parity (key_hex.getText().toCharArray())==true) //Korrekte Key-Paritaet
                        {
                             DES_C.convert_Hex_To_Binary(key_hex.getText());
                             flag_key = true;
                        }
                        else
                        {
                              action_error = 2; //Falsche KEY-Paritaet
                              flag_key     = false;  
                        }
                     }
                     else
                     {
                         action_error = 1; //Falsche KEY-Digits
                         flag_key     = false;
                     }
               }
               else
               {       //ESSLINGER
                       errors[0] = "The Hex-length of the MANUAL KEY is " + key_hex.getText().length() + ", but it must be 16.";
                       action_error = 0; //Falsche KEY-Laenge
                       flag_key     = false;
               }
            }
            else
                    flag_key = true; //Key != manual key   ==>   key = predefined key
                    
                    
            //Similar Check fuer INPUT "in_hex", jedoch entfaellt Paritaets-Test (nur Test auf LAENGE = 16 +++ Korrekte HEX-Digits)
            boolean flag_input = false;
            in_hex.setText(DES_C.cleanTheString(in_hex.getText()));    //ESSLINGER
            if(in_hex.getText().length() == 16)  //Korrekte INPUT-Lanege
            {
                  if(isHexDigit(in_hex.getText()))  //Korrekte INPUT-Digits
                  {  //"true" erzeugt einen binary String der Laenge 64
                     String data_string = DES_C.hexToBinary(in_hex.getText(),true);
                     int [] data = new int[64];
                     for(int k=0; k<data.length; k++)
                              data[k] = Character.getNumericValue(data_string.charAt(k));
                      
                     DES_C.DES_plaintext = data;
                     flag_input       = true;
                  }
                  else
                  {
                      action_error = 1; //Falsche INPUT-Digits
                      flag_input   = false;
                  }
            }
            else
            {       //ESSLINGER
                    errors[0] = "The Hex-length of INPUT is " + in_hex.getText().length() + ", but it must be 16.";
                    action_error = 0; //Falsche INPUT-Laenge
                    flag_input   = false;
            }

            //********************************************************
            
            //Befuellen aller Tabellen aus "DES_C"  +++  Colorierung  +++  Einsetzten Hamming-Distanzen   
            if(flag_key && flag_input)
            {
                  DES_C.doOperation(encrypt_key_selected);
                  putValues(output1, 0, 17, 1, 32, DES_C.get_m0_to_m17());
                  doColoring(0, 17, 1, 32, output1, true, 2, DES_C.DES_action_type);
                  showDist(1, 32, 1, 17, 33, output1, true);
                  
                  putValues(output2, 0, 64, 1, 63, DES_C.get_DES_cipher_Matrix());
                  doColoring(0, 64, 1, 64, output2, true, 3, DES_C.DES_action_type);
                  showDist(1, 64, 1, 64, 65, output2, false);
            
                  putValues(output3, 0, 15, 1, 48, DES_C.get_DES_Rundenkeys());
                  doColoring(0, 15, 1, 48, output3, false, 5, DES_C.DES_action_type);
                   
                  putValues(output4, 0, 33, 1, 28, DES_C.CD_mix);
                  doColoring(0, 33, 1, 28, output4, false, 6, DES_C.DES_action_type);  
                  
                  int [] DES_ciphertext_panel2 = DES_C.DES_ciphertext;
                  out_hex.setText(new String(DES_C.convert_Binary_To_Hex(DES_ciphertext_panel2))); //Setting des OUTPUTS in Panel 2 (hex)
                
                
                  //ESSLINGER
                  //ADDITION OF BLANKS zum einfacheren Interpretieren von bin-Quadrupels als Hex-values
                  String out_string = "";                               
                  for(int k=0; k<DES_C.DES_ciphertext.length; k++)
                  {
                    out_string = out_string + Integer.toString(DES_C.DES_ciphertext[k]);   //Setting des OUTPUTS in Panel 2 (binary)
                    if(k>0 && (k+1)%4 == 0)
                        out_string = out_string + " ";
                  }
                
                  out_bin.setText(out_string);
                
                
                  //Inputs fuer Matrizzen A, B
                  putValues(output6, 0, 7, 0, 7, DES_C.DES_dist_1_Ciphertext_Matrix);
                  doColoring(1, 7, 1, 7, output6, false, 4, DES_C.DES_action_type);
                  
                  putValues(output7, 0, 7, 0, 7, DES_C.DES_dist_2_Ciphertext_Matrix);
                  doColoring(1, 7, 1, 7, output7, false, 4, DES_C.DES_action_type);
  
            }
             else
            {
                JOptionPane.showMessageDialog(null, errors[action_error]);                      
            }       
        }
        else 
        {
        if(ae.getSource() == in2_action)    //in2_action ist im Panel ANTI-/FIXED POINT (Panel 8)
        {    System.out.println("ACTION 2 = IN PROCESS");
             if(fixed.isSelected())
                     DES_C.DES_fixed_status = 0;
             else
                     DES_C.DES_fixed_status = 1;
             
             inf_bin.setText(DES_C.cleanTheBinString(inf_bin.getText()));                   //ESSLINGER
             System.out.println(inf_bin.getText());
             if(check_Bin_Input(inf_bin.getText()))  //Check:  Korrekter binary Input ?
             {
                   int [] data = new int[32];
                   for(int k=0; k<data.length; k++)
                          data[k] = Character.getNumericValue(inf_bin.getText().charAt(k));  
           
                   DES_C.DES_m8 = data;
                   
                   //System.out.println("Panel 8:      " + fix_key_selected + " Fixed Selection >> " + fixed.isSelected());
                   DES_C.doOperation(fix_key_selected);
                   putValues(output5, 0, 9, 1, 32, DES_C.get_m8_to_m17());
                   doColoring(0, 9, 1, 32, output5, true, 7, DES_C.DES_action_type);
                   showDist(1, 32, 1, 9, 33, output5,true);
                   
                   int [] DES_fixed_antifixed;
                   if(fixed.isSelected())
                       DES_fixed_antifixed = DES_C.DES_fixedpoint;
                   else
                       DES_fixed_antifixed = DES_C.DES_anti_fixedpoint;
                       
                   outf_hex.setText(new String(DES_C.convert_Binary_To_Hex(DES_fixed_antifixed))); //Setting des OUTPUTS in Panel 8
             }
             else
             {
                    int L = inf_bin.getText().length();                          //ESSLINGER
                    String data_L = Integer.toString(L);
                    JOptionPane.showMessageDialog(null, "INVALID binary INPUT-Length of " + L + ".");   
             }
        }
        else
        {
           if(ae.getSource() == in3_action)
           {
            System.out.println("ACTION 3 = IN PROCESS");
            boolean flag_input = false;
            
            in_dka.setText(DES_C.cleanTheString(in_dka.getText()));                   //ESSLINGER
            if(in_dka.getText().length() == 16)  //Korrekte INPUT-Laenge
            {
                  System.out.println("INPUT-LENGTH-TEST = OK");
                  if(isHexDigit(in_dka.getText()))  //Korrekte INPUT-Digits
                  {  
                     //"true" erzeugt einen binary String der Laenge 64
                     String data_string = DES_C.hexToBinary(in_dka.getText(),true);
                     DES_C.DES_action_type = 0; 
                     System.out.println("INPUT-DIGIT-TEST = OK");
                     
                     int [] data = new int[64];
                     for(int k=0; k<data.length; k++)
                              data[k] = Character.getNumericValue(data_string.charAt(k));
                      
                     DES_C.DES_delta_Plaintext = data;
                     System.out.println("DKA-DELTA-INPUT = 0123456789ABCDEF :"); System.out.println("");
                     flag_input       = true;
                     
                     //DES_C.key_user  = DES_C.key_k3;
                     DES_C.key_user  = DES_C.generate_random_key();                   //TO BE CHECKED
                     System.out.println("USER-KEY im DKA-Panel ?= (0000 0001)^8 :");
                     for(int j=0; j< 8; j++)
                     {       
                             for(int k=0; k<8; k++)
                                     System.out.print(DES_C.key_user[8*j+k] + " ");
                             System.out.println();
                     }
                      
                      
                      //interger-array(64) --> Hex-array --> String
                      random_k_dka.setText(new String(DES_C.convert_Binary_To_Hex(DES_C.key_user)));
                      
                     
                     //DES_C.DES_m_Plaintext = DES_C.DES_input_D;
                     DES_C.DES_m_Plaintext = DES_C.generate_random_binary_array(64);      //ESSLINGER
                      
                    //random-binary-array(64) --> Hex-array --> String
                     random_m_dka.setText(new String(DES_C.convert_Binary_To_Hex(DES_C.DES_m_Plaintext)));
                      
                      
                      
                     System.out.println("");System.out.println("");
                     System.out.println("USER-INPUT im DKA-Panel ?= (1101)^16 :");
                     for(int j=0; j< 8; j++)
                     {       
                             for(int k=0; k<8; k++)
                                     System.out.print(DES_C.DES_m_Plaintext[8*j+k] + " ");
                             System.out.println("");
                     }
                     System.out.println("");
                     
                     for(int i=0; i<data.length; i++)   
                         DES_C.DES_m_oplus_Delta_Plaintext[i] = DES_C.DES_m_Plaintext[i] ^ DES_C.DES_delta_Plaintext[i];
                  }
                  else
                  {
                      action_error = 1; //Falsche INPUT-Digits
                      flag_input   = false;
                  }
            }
            else
            {
                    errors_DKA[0] = "Your INPUT's Hex-length is " + in_dka.getText().length() +  ", but it must be 16.";                 //ESSLINGER
                    action_error = 0; //Falsche INPUT-Laenge 
                    flag_input   = false;
                    //JOptionPane.showMessageDialog(null, "INVALID INPUT. Enter again !");
            }
               
               
             if(flag_input)
             {
                 DES_C.doOperation(16);    //??? CORRECT ????        
                 putValues(output8, 0, 15, 0, 7, DES_C.get_DES_active_SBoxes());
                 doColoring_vsActivity(0, 15, 0, 7, output8, true, 8, DES_C.DES_action_type);
                 //if (DES_active_SBoxes_in_panel[r][c] == 1) cell(DES_active_SBoxes_in_panel[r][c]) = Color(c3); else Color.white
             }
             else
             {
                
                JOptionPane.showMessageDialog(null, errors_DKA[action_error]);
             }
        }
        }      
    }

        
        //Alles im Panel "ANTI-/FIXED POINTS"   (Panel 8)
        //Je nach Selektion En-/Disabling der Keys in Panel 8
        if ("FIXED".equals( ae.getActionCommand() )) 
        {         
           fk0.setEnabled(true);
           fk5.setEnabled(true);
           fk10.setEnabled(true);
           fk15.setEnabled(true);
           
           fk3.setSelected(false);
           fk6.setSelected(false);
           fk9.setSelected(false);
           fk12.setSelected(false);
           
           fk3.setEnabled(false);
           fk6.setEnabled(false);
           fk9.setEnabled(false);
           fk12.setEnabled(false);       
        } 
        else if ("ANTI_FIXED".equals(ae.getActionCommand()))
        {  //Je nach Selektion En-/Disabling der Keys in Panel 8
           fk0.setEnabled(false);
           fk5.setEnabled(false);
           fk10.setEnabled(false);
           fk15.setEnabled(false);           
           
           fk0.setSelected(false);
           fk5.setSelected(false);
           fk10.setSelected(false);
           fk15.setSelected(false);
           
           fk3.setEnabled(true);
           fk6.setEnabled(true);
           fk9.setEnabled(true);
           fk12.setEnabled(true);
           
           validate();
        }
        
    }

}