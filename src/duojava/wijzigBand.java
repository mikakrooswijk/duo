 
package duojava;
 
 
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

public class wijzigBand extends JPanel {
    
    public int idValue = 0;
    
    private JPanel idSelect;
    private JButton verwijder, cancel, idMeer, idMinder;
    private JTextField bandId, bandNaam, Beschr, idTextField;
    private JLabel Id, naam, discr, idLabel;
    
    public wijzigBand(){
        
        idSelect = new JPanel();
        
         
        idSelect.add(idMinder = new JButton("<<"));
        idSelect.add(idTextField = new JTextField());
        idSelect.add(idMeer = new JButton(">>"));
        
        idSelect.setLayout(new GridLayout(1, 4,5,10));
        
        idTextField.setText("" + idValue);
        idTextField.setHorizontalAlignment(JTextField.CENTER); 
        
        idMinder.addActionListener(new idMinder());
        idMeer.addActionListener(new idMeer());
        
        
         
         
        
         
        verwijder = new JButton("wijzig band");
        cancel = new JButton("cancel");
        
        verwijder.addActionListener(new wijzBand());
   
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
        add(cancel);
    }
    
    class verijderBand implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //band verwijderen
        }
    } 
    
    class idMinder implements ActionListener{
        public void actionPerformed(ActionEvent e){
             idValue--;
             idTextField.setText("" + idValue);
        }
    } 
    
    class idMeer implements ActionListener{
        public void actionPerformed(ActionEvent e){
             idValue++;
             idTextField.setText("" + idValue);
        }
    } 
    
    class wijzBand implements ActionListener {
    
   

    public void maakConnect() throws SQLException {
       
         Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost/duoeventmanager", "duo1", "duo");
         Statement statement = connection.createStatement();
          
         statement.executeUpdate("UPDATE arties SET beschrijving = '" + Beschr.getText() + "', naam = '" + bandNaam.getText() + "' WHERE atiesID = '" + idTextField.getText() + "';");
         Beschr.setText("");
         bandNaam.setText("");
         idTextField.setText("0");
    }

    public void actionPerformed(ActionEvent e) {
       
        try {
            
            maakConnect();
        } catch (SQLException ex) {
            Logger.getLogger(wijzBand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
}

