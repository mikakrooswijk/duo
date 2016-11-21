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

public class nieuweBand extends JPanel {

    public JTextField bandNaam, tijdStip, podium;
    public JLabel Naam, tijd, stage;
    private JButton maakBand;

    public nieuweBand() {

        Font font1 = new Font("SansSerif", Font.BOLD, 15);

        bandNaam = new JTextField("");
        tijdStip = new JTextField("");
        podium = new JTextField("");

        Naam = new JLabel("band naam");
        tijd = new JLabel("ID");
        stage = new JLabel("beschrijving");

        maakBand = new JButton("maak band");
        maakBand.addActionListener(new maakBand());

        this.setLayout(new GridLayout(4, 2, 5, 10));
        Border border = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        this.setBorder(border);

        add(Naam);
        add(bandNaam);

        add(tijd);
        add(tijdStip);

        add(stage);
        add(podium);

        add(maakBand);

    }
    
   class maakBand implements ActionListener {
    
   

    public void maakConnect() throws SQLException {
       
         Connection  connection = DriverManager.getConnection("jdbc:mysql://localhost/duoeventmanager", "duo1", "duo");
         Statement statement = connection.createStatement();
          
         statement.executeUpdate("INSERT INTO arties VALUES (" + tijdStip.getText()  + ",'" + podium.getText() + "','" + bandNaam.getText() + "');");
         tijdStip.setText("");
         podium.setText("");
         bandNaam.setText("");
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


