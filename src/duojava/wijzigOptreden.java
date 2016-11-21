/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 *
 * @author Mika Krooswijk
 */
public class wijzigOptreden extends JPanel {
    
    public int idValue = 0;
    
    private JPanel idSelect;
    private JButton wijzig, idMeer, idMinder;
    private JTextField optredenID, optedenNaam, beginTijd, EindTijd, podiumId, artiesId, idTextField;
    private JLabel Id, naamLabel, btijdLabel, ETijdLabel, podiumLabel, artiestLabel;
    
    public wijzigOptreden(){
     
        
        idSelect = new JPanel();
        
         
        idSelect.add(idMinder = new JButton("<<"));
        idSelect.add(idTextField = new JTextField());
        idSelect.add(idMeer = new JButton(">>"));
        
        idSelect.setLayout(new GridLayout(1, 4,5,10));
        
        idTextField.setText("" + idValue);
        idTextField.setHorizontalAlignment(JTextField.CENTER); 
        
        idMinder.addActionListener(new wijzigOptreden.idMinder());
        idMeer.addActionListener(new wijzigOptreden.idMeer());
        
        
         
         
        
         
        wijzig = new JButton("wijzig band");
        
        
         
   
        optredenID = new JTextField(" ");
        optedenNaam = new JTextField(" ");
        beginTijd = new JTextField(" ");
        EindTijd = new JTextField(" ");
        podiumId = new JTextField(" ");
        artiesId = new JTextField(" ");
        
        Id = new JLabel("Optreden ID");
        naamLabel = new JLabel("naam band");
        btijdLabel = new JLabel("begin tijd");
        ETijdLabel = new JLabel("eind tijd");
        podiumLabel = new JLabel("podium Id");
        artiestLabel = new JLabel("artiest Id");
        
        
        this.setLayout(new GridLayout(7, 3,5,10));
        Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        this.setBorder(border);
        
        wijzig.addActionListener(new wijzOp());
        
        add(Id);
        add(idSelect);
         
 
        add(naamLabel);
        add(optedenNaam);
        
        add(btijdLabel);
        add(beginTijd);
        
        add(ETijdLabel);
        add(EindTijd);
        
        add(podiumLabel);
        add(podiumId);
        
        add(artiestLabel);
        add(artiesId);
        
        add(wijzig);
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
    
    
    
    
    
    
    
    
    
    
    
    
    
    class wijzOp implements ActionListener {
    
   

    public void maakConnect() throws SQLException {
       
         Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost/duoeventmanager", "duo1", "duo");
         Statement statement = connection.createStatement();
          
         statement.executeUpdate("UPDATE optreden SET podiumID = '" + podiumId.getText() + "', artiesID = '" + artiesId.getText() + "', startTijd = '" + beginTijd.getText() + "', eindTijd = '" +EindTijd.getText()+ "'WHERE optredenID = '" + idTextField.getText() + "';");
          
         idTextField.setText("0");
    }

    public void actionPerformed(ActionEvent e) {
       
        try {
            
            maakConnect();
        } catch (SQLException ex) {
            Logger.getLogger(wijzOp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
}
