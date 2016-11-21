  
package duojava;
 
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

public class wijzigDisplay extends JFrame {
    public wijzigDisplay(){
        setSize( 500 , 300 );
        setLocation(600, 400);     
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setTitle( "band wijzigen" );
        setContentPane(new wijzigBand());
        setVisible( true );
    }
    
}
