 
package duojava;
 
 
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;

public class verwijderBand extends JPanel {
    
    public int idValue = 0;
    
    private JPanel idSelect;
    private JButton verwijder, cancel, idMeer, idMinder;
    private JTextField bandId, bandNaam, Beschr, idTextField;
    private JLabel Id, naam, discr, idLabel;
    
    public verwijderBand(){
        
         
        
        
        idSelect = new JPanel();
        
         
        idSelect.add(idMinder = new JButton("<<"));
        idSelect.add(idTextField = new JTextField());
        idSelect.add(idMeer = new JButton(">>"));
        
        idSelect.setLayout(new GridLayout(1, 4,5,10));
        
        idTextField.setText("" + idValue);
        idTextField.setHorizontalAlignment(JTextField.CENTER); 
        
        idMinder.addActionListener(new idMinder());
        idMeer.addActionListener(new idMeer());
        
    
        
        
         
         
        
         
        verwijder = new JButton("verwijder band");
        cancel = new JButton("cancel");
        verwijder.addActionListener(new verwrBand());
        
        
        
        
   
        bandId = new JTextField(" ");
        bandNaam = new JTextField(" ");
        Beschr = new JTextField(" ");
        
        Id = new JLabel("Band ID");
        naam = new JLabel("Bandnaam");
        discr = new JLabel("Beschrijving");
        
        this.setLayout(new GridLayout(4, 3,5,10));
        Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        this.setBorder(border);
        
        add(Id);
        add(idSelect);
         
 
        add(naam);
        add(bandNaam);
        
        add(discr);
        add(Beschr);
        
        add(verwijder);
        
    }
    
    class verwrBand implements ActionListener {
    
   

    public void maakConnect() throws SQLException {
       
         Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost/duoeventmanager", "duo1", "duo");
         Statement statement = connection.createStatement();
          
         statement.executeUpdate("DELETE FROM arties WHERE atiesID =" + idTextField.getText() +";"); 
         Beschr.setText("delete succesfull");
    }

    public void actionPerformed(ActionEvent e) {
       
        try {
            
            maakConnect();
        } catch (SQLException ex) {
            Logger.getLogger(verwrBand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
    
    
    
    class idMinder implements ActionListener{
        public void actionPerformed(ActionEvent e){
             idValue--;
             idTextField.setText("" + idValue);
             Beschr.setText("");
        }
    } 
    
    class idMeer implements ActionListener{
        public void actionPerformed(ActionEvent e){
             idValue++;
             idTextField.setText("" + idValue);
             Beschr.setText("");
        }
    } 
    
    
}
