 
package duojava;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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

 
public class zoekBand extends JPanel{
    public int idValue = 0;
    private JPanel idSelect;
    private JTextField idTextField, bandIdText, naamText, beschText, optredenIdText;
    private JButton idMinder, idMeer, zoekband;
    private JLabel idLabel, naamLabel, beschLabel, optredenIdLabel;
    
    
    public zoekBand(){
        
        idSelect = new JPanel();
        
         
        idSelect.add(idMinder = new JButton("<<"));
        idSelect.add(idTextField = new JTextField());
        idSelect.add(idMeer = new JButton(">>"));
        
        idSelect.setLayout(new GridLayout(1, 4,5,10));
        
        idTextField.setText("" + idValue);
        idTextField.setHorizontalAlignment(JTextField.CENTER); 
        
        idMinder.addActionListener(new zoekBand.idMinder());
        idMeer.addActionListener(new zoekBand.idMeer());
        
        this.setLayout(new GridLayout(5, 2,5,10));
        Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        this.setBorder(border);
        
        idLabel = new JLabel("band id");
        naamLabel = new JLabel("band naam");
        beschLabel = new JLabel("beschrijving");
        optredenIdLabel = new JLabel("optreden ID's");
        
        bandIdText = new JTextField("");
        naamText = new JTextField("");
        beschText = new JTextField("");
        optredenIdText = new JTextField("");
        
        zoekband = new JButton("zoeken");
        zoekband.addActionListener(new zoekBandHandler());
        
        add(idLabel);
        add(idSelect);
        
        add(naamLabel);
        add(naamText);
        
        add(beschLabel);
        add(beschText);
        
        add(optredenIdLabel);
        add(optredenIdText);
        
        add(zoekband);
        
        
        
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
    class zoekBandHandler implements ActionListener {
    
   

    public void maakConnect() throws SQLException {
       
         Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost/duoeventmanager", "duo1", "duo");
         Statement statement = connection.createStatement();
         
         String bandNaam = "";
         int id = 0;
         String bandBesch = "";
         int optredenID = 0;
          
         ResultSet result = statement.executeQuery("SELECT atiesID, naam, beschrijving FROM arties WHERE atiesID = " + idTextField.getText() + ";");
         
         if(result.next()){
            bandNaam = result.getString("naam");
            id = result.getInt("atiesID");
            bandBesch = result.getString("beschrijving");
            
        }
         
        ResultSet result1 = statement.executeQuery("SELECT * FROM optreden WHERE artiesID = " + idTextField.getText() + ";");

        if(result1.next()){
            optredenID = result1.getInt("optredenID");
        }
         
         naamText.setText(bandNaam);
         beschText.setText(bandBesch);
         optredenIdText.setText("" + optredenID);
          
        
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
