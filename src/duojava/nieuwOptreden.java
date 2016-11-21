 
package duojava;
 
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

public class nieuwOptreden extends JPanel {
    public JTextField optredenNaam, beginTijd, eindTijd, podiumID, artiestID ;
    public JLabel Naam, Btijd,ETijd, stageIDLabel, artiestIDLabel;
    private JButton maakBand;

    public nieuwOptreden() {

        Font font1 = new Font("SansSerif", Font.BOLD, 15);

        optredenNaam = new JTextField("");
        beginTijd = new JTextField("");
        eindTijd = new JTextField("");
        podiumID = new JTextField("");
        artiestID = new JTextField("");

        Naam = new JLabel("optreden id");
        Btijd = new JLabel("begin tijd");
        ETijd = new JLabel("eind tijd");
        stageIDLabel = new JLabel("podium id");
        artiestIDLabel = new JLabel("aritest id");

        maakBand = new JButton("maak optreden");
        
        maakBand.addActionListener(new maakOp());
        

        this.setLayout(new GridLayout(6, 2, 5, 10));
        Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        this.setBorder(border);

        add(Naam);
        add(optredenNaam);

        add(Btijd);
        add(beginTijd);
        
        add(ETijd);
        add(eindTijd);
        
        add(stageIDLabel);
        add(podiumID);

        add(artiestIDLabel);
        add(artiestID);

        add(maakBand);

    }
    
    class maakOp implements ActionListener {
    
   

    public void maakConnect() throws SQLException {
       
         Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost/duoeventmanager", "duo1", "duo");
         Statement statement = connection.createStatement();
          
         statement.executeUpdate("INSERT INTO optreden VALUES (" + optredenNaam.getText()  + ",'" + podiumID.getText() + "','" + artiestID.getText() + "','" +beginTijd.getText() + "','" +eindTijd.getText() + "');");
         optredenNaam.setText("");
         beginTijd.setText("");
         eindTijd.setText("");
         podiumID.setText("");
         artiestID.setText("");
    }

    public void actionPerformed(ActionEvent e) {
       
        try {
            
            maakConnect();
        } catch (SQLException ex) {
            Logger.getLogger(maakOp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
}

