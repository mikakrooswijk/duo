 
package duojava;

import java.awt.Color;
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


public class verwijderOptreden extends JPanel{
    
    public int idValue = 0;
    
    private JPanel idSelect;
    private JButton verwijder, idMeer, idMinder;
    private JTextField optredenId, deleteStatus, idTextField;
    private JLabel Id, deletestatusLabel, idLabel;
    
    public verwijderOptreden(){
        idSelect = new JPanel();
        
         
        idSelect.add(idMinder = new JButton("<<"));
        idSelect.add(idTextField = new JTextField());
        idSelect.add(idMeer = new JButton(">>"));
        
        idSelect.setLayout(new GridLayout(1, 4,5,10));
        
        idTextField.setText("" + idValue);
        idTextField.setHorizontalAlignment(JTextField.CENTER); 
        
        idMinder.addActionListener(new verwijderOptreden.idMinder());
        idMeer.addActionListener(new verwijderOptreden.idMeer());
        
        
        this.setLayout(new GridLayout(3, 2,5,10));
        Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        this.setBorder(border);
        
        
        
        verwijder = new JButton("verwijder optreden");
        
        optredenId = new JTextField(" ");
        deleteStatus = new JTextField("");
        
        Id = new JLabel("optreden ID");
        deletestatusLabel = new JLabel("status");
        
        verwijder.addActionListener(new verwOp());
         
        add(Id);
        add(idSelect);
        
        add(deletestatusLabel);
        add(deleteStatus);
        
        add(verwijder);
         
        
        
        
    }
    
   class verwOp implements ActionListener {
    
   

    public void maakConnect() throws SQLException {
       
         Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost/duoeventmanager", "duo1", "duo");
         Statement statement = connection.createStatement();
          
         statement.executeUpdate("DELETE FROM optreden WHERE optredenID =" + idTextField.getText() +";"); 
         deleteStatus.setText("delete succesfull");
    }

    public void actionPerformed(ActionEvent e) {
       
        try {
            
            maakConnect();
        } catch (SQLException ex) {
            Logger.getLogger(verwOp.class.getName()).log(Level.SEVERE, null, ex);
        }
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
   }
