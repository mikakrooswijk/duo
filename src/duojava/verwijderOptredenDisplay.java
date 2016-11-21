 
package duojava;
 
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

public class verwijderOptredenDisplay extends JFrame {
    public verwijderOptredenDisplay(){
        setSize( 500 , 300 );
        setLocation(600, 400);     
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setTitle( "band verwijderen" );
        setContentPane(new verwijderOptreden());
        setVisible( true );
    }
    
}