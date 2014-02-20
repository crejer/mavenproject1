package Racegame;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Hello world!
 *
 */
public class CarGame 
{
    public static void main( String[] args )
    {
        // Creating frame
        
        JFrame frame = new JFrame("VOP team01 Racing");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        // creating world to race
        GameWorld s = new GameWorld();
        
        
        
        
        
        
        // make frame visible
        frame.setContentPane(s);
        frame.setSize(2000, 2000); 
        frame.setVisible(true); 
        
    }
}
