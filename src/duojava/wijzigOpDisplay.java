  
package duojava;
 
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

public class wijzigOpDisplay extends JFrame {
    public wijzigOpDisplay(){
        setSize( 500 , 400 );
        setLocation(600, 400);     
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setTitle( "band wijzigen" );
        setContentPane(new wijzigOptreden());
        setVisible( true );
    }
    
}
