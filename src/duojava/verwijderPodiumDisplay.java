package duojava;
 
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

public class verwijderPodiumDisplay extends JFrame {
    public verwijderPodiumDisplay(){
        setSize( 500 , 300 );
        setLocation(600, 400);     
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setTitle( "podium verwijderen" );
        setContentPane(new verwijderPodium());
        setVisible( true );
    }
    
}