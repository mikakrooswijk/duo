 
package duojava;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.*;  
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.*;
 
public class UIPanel extends JPanel {
    private JButton aanmaak1,aanmaak2,aanmaak3, wijzig1, wijzig2, wijzig3, verw1, verw2, verw3, zoekKnop ;
    private JLabel label1, label2, label3, label4, label5, info;
    private JTextField zoekNaam, zoekID, zoekResult;
    private JPanel row1, row2, row3, row4, row5;
     
     
     
    
    public UIPanel(){
        
        Font font1 = new Font("SansSerif", Font.BOLD, 15);
        
        this.setLayout(new GridLayout(5, 2,10,20));
        Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        this.setBorder(border);
        
        row1 = new JPanel();
            
            row1.add(zoekKnop = new JButton("zoek band"));
            row1.setLayout(new GridLayout(1,1,5,10));
            zoekKnop.addActionListener(new zoekBandScherm());
            
        
            
        row2 = new JPanel();
            row2.add(aanmaak1 = new JButton("aanmaken"));
            aanmaak1.addActionListener(new nieuwBandHdlr());
            row2.add(wijzig1 = new JButton("wijzigen"));
            wijzig1.addActionListener(new wijzigHandlr());
            row2.add(verw1 = new JButton("verwijder"));
            verw1.addActionListener(new verwijderBandHdlr());
            row2.setLayout(new GridLayout(1,3,5,10));
            
        row3 = new JPanel();
            row3.add(aanmaak2 = new JButton("aanmaken"));
            aanmaak2.addActionListener(new maakPodium());
            row3.add(wijzig2 = new JButton("wijzigen"));
            wijzig2.addActionListener(new wijzigPodium());
            row3.add(verw2 = new JButton("verwijder"));
            verw2.addActionListener(new verwijderPodium());
            row3.setLayout(new GridLayout(1,3,5,10));
            
            
            
        row4 = new JPanel();
            row4.add(aanmaak3 = new JButton("aanmaken"));
            aanmaak3.addActionListener(new nieuwOp());
            row4.add(wijzig3 = new JButton("wijzigen"));
            wijzig3.addActionListener(new wijzigOp());
            row4.add(verw3 =  new JButton("verwijder"));
            verw3.addActionListener(new verwijderOp());
            row4.setLayout(new GridLayout(1,3,5,10));
            
        row5 = new JPanel();
            row5.add(info = new JLabel("Rick Janssen, Mika Krooswijk klass: 23IVT1C"));
            
            
        
        label1 = new JLabel("zoeken");
        label2 = new JLabel("band");
        label3 = new JLabel("podium");
        label4 = new JLabel("optreden");
        label5 = new JLabel("resultaat");
        
        add(label1);
        add(row1);
        
        
        
        add(label2);
        add(row2);
        
        add(label3);
        add(row3);
        
        add(label4);
        add(row4);
        
        add(row5);
        
         

    
    }
    
    class nieuwBandHdlr implements ActionListener{
        public void actionPerformed(ActionEvent e){
            bandDisplay band = new bandDisplay();
        }
    }
    
    
    
    class verwijderBandHdlr implements ActionListener{
        public void actionPerformed(ActionEvent e){
            verwijderDisplay verw = new verwijderDisplay();
        }
    }
    
     class wijzigHandlr implements ActionListener{
        public void actionPerformed(ActionEvent e){
           wijzigDisplay wijzig = new wijzigDisplay();
        }
    }
     
     class nieuwOp implements ActionListener{
        public void actionPerformed(ActionEvent e){
           nieuwOptredenDisplay nop = new nieuwOptredenDisplay();
        }
    }
     
       class wijzigOp implements ActionListener{
        public void actionPerformed(ActionEvent e){
           wijzigOpDisplay wijz = new wijzigOpDisplay();
        }
    }
       
       class verwijderOp implements ActionListener{
        public void actionPerformed(ActionEvent e){
           verwijderOptredenDisplay wijz = new verwijderOptredenDisplay();
        }
    }
       
    class maakPodium implements ActionListener{
        public void actionPerformed(ActionEvent e){
           maakPodiumDisplay maak = new maakPodiumDisplay();
        }
    }   
    
    class wijzigPodium implements ActionListener{
        public void actionPerformed(ActionEvent e){
           wijzigPodiumDisplay wijzPodium = new wijzigPodiumDisplay();
        }
    }   
    
    class verwijderPodium implements ActionListener{
        public void actionPerformed(ActionEvent e){
           verwijderPodiumDisplay verwijderPodium = new verwijderPodiumDisplay();
        }
    }  
    
    class zoekBandScherm implements ActionListener{
        public void actionPerformed(ActionEvent e){
           zoekBandDisplay zoek = new zoekBandDisplay();
        }
    }  
    
    
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     class zoekBand implements ActionListener {
    
   

    public void maakConnect() throws SQLException {
       
         Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost/duoeventmanager", "duo1", "duo");
         Statement statement = connection.createStatement();
          
         ResultSet result = statement.executeQuery("SELECT atiesID, naam, beschrijving FROM arties WHERE atiesID = " + zoekNaam.getText() + ";");
         String bandNaam = "";
         int id = 0;
         String bandBesch = "";
         
         if(result.next()){
            bandNaam = result.getString("naam");
            id = result.getInt("atiesID");
            bandBesch = result.getString("beschrijving");
     }
         
          
         zoekResult.setText(" band naam: " + bandNaam + ", band ID: " + id + ", beschrijving: " + bandBesch);
    }

    public void actionPerformed(ActionEvent e) {
       
        try {
            
            maakConnect();
        } catch (SQLException ex) {
            Logger.getLogger(zoekBand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
    
    
}
