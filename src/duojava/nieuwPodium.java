
package duojava;

import javax.swing.*;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
 
public class nieuwPodium extends JPanel {
    
    private JLabel idLabel, beschLabel;
    private JTextField idText, beschText;
    private JButton maakKnop;
    
    public nieuwPodium(){
        
        idLabel = new JLabel("podium ID");
        beschLabel = new JLabel("podium beschrijving");
        idText = new JTextField("");
        beschText = new JTextField("");
        maakKnop = new JButton("maak podium");
        
        this.setLayout(new GridLayout(3, 2, 5, 10));
        Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        this.setBorder(border);
        
        maakKnop.addActionListener(new maakBand());
        
        add(idLabel);
        add(idText);
        
        add(beschLabel);
        add(beschText);
        
        add(maakKnop);
        
    }
    
    class maakBand implements ActionListener {
    
   

    public void maakConnect() throws SQLException {
       
        Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost/duoeventmanager", "duo1", "duo");
         Statement statement = connection.createStatement();
          
         statement.executeUpdate("INSERT INTO podium VALUES ('" + idText.getText()  + "','" + beschText.getText() + "');");
         beschLabel.setText("");
         idText.setText("");
    }

    public void actionPerformed(ActionEvent e) {
       
        try {
            
            maakConnect();
        } catch (SQLException ex) {
            Logger.getLogger(maakBand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
}
