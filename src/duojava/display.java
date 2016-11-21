 
package duojava;

import javax.swing.JFrame;

 
public class display extends JFrame {
    
       public display(){
            setSize( 1000 , 500 );
            setLocation(600, 400);    //added 
            setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            setTitle( "duo opdracht" );
            setContentPane(new UIPanel());
            setVisible( true );
       } 
       
}

