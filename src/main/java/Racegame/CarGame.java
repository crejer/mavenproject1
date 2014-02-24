package Racegame;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Hello world!
 *
 */
public class CarGame 
{
    public static void main(String[] args) { 
 // Create application fram and a game surface 
 
 JFrame frame = new JFrame("Car game"); 
 frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); 
 GameWorld s = new GameWorld(); 
 
 // Create a few cars and assign behaviours to them 
 
 Car myCar = new Car("C:\\Users\\jeroen\\Pictures\\car.png"); 
 myCar.updatePosition(450, 450); 
 myCar.setMass(1.0f); 
 myCar.setMaxSpeed(150.0f); 
 myCar.setMaxSteering(70.0f); 
 myCar.addBehaviour(new RoamBehaviour(30, 30, 1890, 1170)); 
 
 
 
 Car myCar3 = new Car("C:\\Users\\jeroen\\Pictures\\sportscar.png"); 
 myCar3.updatePosition(250, 250); 
 myCar3.setMass(1.0f); 
 myCar3.setMaxSpeed(120.0f); 
 myCar3.setMaxSteering(300.0f); 
 myCar3.updateVelocity(120.0f, 0.0f);  PlayerSteeringBehaviour steering = new PlayerSteeringBehaviour(); 
 myCar3.addBehaviour(steering); 
 myCar3.addBehaviour(new BounceOffWallsBehaviour(30, 30, 1890, 1170)); 
 s.addKeyListener(steering); 
 
 Car myCar2 = new Car("C:\\Users\\jeroen\\Pictures\\car.png"); 
 myCar2.updatePosition(50, 50); 
 myCar2.setMass(1.0f); 
 myCar2.setMaxSpeed(150.0f); 
 myCar2.setMaxSteering(100.0f); 
 myCar2.addBehaviour(new PursuitBehaviour(myCar3)); 
 myCar2.addBehaviour(new BounceOffWallsBehaviour(30, 30, 1890, 1170)); 
 
 // Add the cars to the game surface so that 
 // they will be drawn 
 
 s.getVehicles().add(myCar); 
 s.getVehicles().add(myCar2); 
 s.getVehicles().add(myCar3); 
 
 // Display the game surface in the frame, and 
 // make the frame visible 
 
 frame.setContentPane(s); 
 frame.setSize(1920, 1200); 
 frame.setVisible(true); 
 
 // Since we want to receive keyboard events, 
 // the game surface needs to have the input focus 
 
 s.requestFocusInWindow(); 
 
 // Create the animation thread and start it 
 
 Driving a = new Driving(s); 
 Thread t = new Thread(a); 
 t.start(); 
 }
}