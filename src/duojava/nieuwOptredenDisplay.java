 
package duojava;
 
import javax.swing.*;

public class nieuwOptredenDisplay extends JFrame {
    public nieuwOptredenDisplay(){
        setSize( 500 , 400 );
        setLocation(600, 400);     
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setTitle( "maak optreden" );
        setContentPane(new nieuwOptreden());
        setVisible( true );
    }
}
