/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Racegame;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;

/**
 *
 * @author jeroen
 */
public class PlayerSteeringBehaviour implements Behaviour, KeyListener { 
 
 protected boolean steering = false; 
 protected boolean speeding = false;
 protected float direction = 1.0f; 
 protected float velocity = 1.0f;
 
 public void keyPressed(KeyEvent e) { 
 if (e.getKeyCode() == 37) { // Cursor left 
 steering = true; 
 direction = -1.0f; 
 } 
 if (e.getKeyCode() == 39) { // Cursor right 
 steering = true; 
 direction = 1.0f; 
 } 
 if (e.getKeyCode() == 38) { // Cursor up
 speeding = true;
 velocity = 1.0f;
 }
 if (e.getKeyCode() == 40) { // Cursor down
 speeding = true;
 velocity = -1.0f;
 }
 } 
 
 public void keyReleased(KeyEvent e) { 
 steering = false; 
 speeding = false;
 } 
 
 public void keyTyped(KeyEvent e) { 
 } 
 
 public void update(Vehicle v, float dt) { 
 if (steering) { 
 Point2D.Float side = v.getSideVector(); 
 Point2D.Float desired_velocity = new Point2D.Float(side.x * direction, side.y * direction); 
 Vehicle.scale(desired_velocity, v.getMaxSteering()); 
 v.updateSteering(desired_velocity.x, desired_velocity.y);  } else { 
 v.updateSteering(v.getVelocity()); 
 } 
 //if (speeding){
 //v.updateVelocity(v.getVelocity().x+velocity, v.getVelocity().y+velocity);
 //v.updateVelocity(v.getVelocity());
 //}
 } 
} 

