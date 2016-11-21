package duojava;
 
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

public class wijzigPodiumDisplay extends JFrame {
    public wijzigPodiumDisplay(){
        setSize( 500 , 300 );
        setLocation(600, 400);     
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setTitle( "podium wijzigen" );
        setContentPane(new wijzigPodium());
        setVisible( true );
    }
    
}
