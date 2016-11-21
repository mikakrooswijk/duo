package duojava;
 
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

public class maakPodiumDisplay extends JFrame {
    public maakPodiumDisplay(){
        setSize( 500 , 300 );
        setLocation(600, 400);     
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setTitle( "podium maken" );
        setContentPane(new nieuwPodium());
        setVisible( true );
    }
    
}
