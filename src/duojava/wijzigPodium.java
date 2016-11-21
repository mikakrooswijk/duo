 
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

public class wijzigPodium extends JPanel{
    public int idValue = 0;
    
    private JPanel idSelect;
    private JTextField idTextField, beschText;
    private JButton idMinder, idMeer, wijzigPodium;
    private JLabel beschLabel, idLabel;
    
    public wijzigPodium(){
        
        idSelect = new JPanel();
        
         
        idSelect.add(idMinder = new JButton("<<"));
        idSelect.add(idTextField = new JTextField());
        idSelect.add(idMeer = new JButton(">>"));
        
        idSelect.setLayout(new GridLayout(1, 4,5,10));
        
        idTextField.setText("" + idValue);
        idTextField.setHorizontalAlignment(JTextField.CENTER); 
        
        idMinder.addActionListener(new wijzigPodium.idMinder());
        idMeer.addActionListener(new wijzigPodium.idMeer());
        
        beschText  = new JTextField("");
        beschLabel = new JLabel("beschrijving");
        idLabel = new JLabel("podium ID");
        wijzigPodium = new JButton("wijzig podium");
        
        wijzigPodium.addActionListener(new wijzPodium());
        
        this.setLayout(new GridLayout(3, 3,5,10));
        Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        this.setBorder(border);
        
        
        
        add(idLabel);
        add(idSelect);
        
        add(beschLabel);
        add(beschText);
        
        add(wijzigPodium);
        
        
        
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
    
    
    
    
    
    
    
    
    
    
    
    class wijzPodium implements ActionListener {
    
   

    public void maakConnect() throws SQLException {
       
         Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost/duoeventmanager", "duo1", "duo");
         Statement statement = connection.createStatement();
          
         statement.executeUpdate("UPDATE podium SET beschrijving = '" + beschText.getText() + "'WHERE podiumID = '" + idTextField.getText() + "';");
          
         beschText.setText("");
         idTextField.setText("0");
    }

    public void actionPerformed(ActionEvent e) {
       
        try {
            
            maakConnect();
        } catch (SQLException ex) {
            Logger.getLogger(wijzPodium.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
    
}
