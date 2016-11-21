package duojava;
 
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.Border;

public class zoekBandDisplay extends JFrame {
    public zoekBandDisplay(){
        setSize( 500 , 300 );
        setLocation(600, 400);     
        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setTitle( "band zoeken" );
        setContentPane(new zoekBand());
        setVisible( true );
    }
    
}
