
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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;


public class verwijderPodium extends JPanel {
    public int idValue = 0;
    private JPanel idSelect;
    private JButton idMeer, idMinder, verwijder;
    private JLabel idLabel, status;
    private JTextField idTextField, statusTextField;
    
    public verwijderPodium(){
        
        idSelect = new JPanel();
        
         
        idSelect.add(idMinder = new JButton("<<"));
        idSelect.add(idTextField = new JTextField());
        idSelect.add(idMeer = new JButton(">>"));
        
        idSelect.setLayout(new GridLayout(1, 4,5,10));
        
        idTextField.setText("" + idValue);
        idTextField.setHorizontalAlignment(JTextField.CENTER); 
        
        idMinder.addActionListener(new verwijderPodium.idMinder());
        idMeer.addActionListener(new verwijderPodium.idMeer());
        
        this.setLayout(new GridLayout(3, 3,5,10));
        Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        this.setBorder(border);
        
        verwijder = new JButton("verwijder");
        statusTextField = new JTextField("");
        idLabel = new JLabel("podium ID");
        status = new JLabel("status");
        
        verwijder.addActionListener(new verwrPodium());
        
        add(idLabel);
        add(idSelect);
        
        add(status);
        add(statusTextField);
        
        add(verwijder);
        
         
    }
    
     class idMinder implements ActionListener{
        public void actionPerformed(ActionEvent e){
             idValue--;
             idTextField.setText("" + idValue);
             
             statusTextField.setText("");
        }
    } 
    
    class idMeer implements ActionListener{
        public void actionPerformed(ActionEvent e){
             idValue++;
             idTextField.setText("" + idValue);
              
             statusTextField.setText("");
        }
    } 
    
    
    
    
    class verwrPodium implements ActionListener {
    
   

    public void maakConnect() throws SQLException {
       
         Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost/duoeventmanager", "duo1", "duo");
         Statement statement = connection.createStatement();
          
         statement.executeUpdate("DELETE FROM podium WHERE podiumID =" + idTextField.getText() +";"); 
         statusTextField.setText("delete succesfull");
    }

    public void actionPerformed(ActionEvent e) {
       
        try {
            
            maakConnect();
        } catch (SQLException ex) {
            Logger.getLogger(verwrPodium.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
}
