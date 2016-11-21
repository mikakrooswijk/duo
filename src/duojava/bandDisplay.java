 
package duojava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;


public class bandDisplay extends JFrame {
       
    public bandDisplay(){
        setSize( 500 , 300);
        setLocation(600, 400);     
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setTitle( "maak band" );
        setContentPane(new nieuweBand());
        setVisible( true );
    }
    
       
   
}
