 
package duojava;
 
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

public class verwijderDisplay extends JFrame {
    public verwijderDisplay(){
        setSize( 500 , 300 );
        setLocation(600, 400);     
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setTitle( "band verwijderen" );
        setContentPane(new verwijderBand());
        setVisible( true );
    }
    
}