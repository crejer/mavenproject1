/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Racegame;

import java.util.*;

/**
 *
 * @author jeroen
 */



public class Driving implements Runnable { 
 protected GameWorld game; 
 
 public Driving(GameWorld world) { 
 game = world; 
 } 
 
 public void run() { 
 long time = System.currentTimeMillis(); 
 for (;;) { 
 ArrayList vehicles = game.getVehicles(); 
 
 // Update position, velocity etc. of vehicles 
 
 long t = System.currentTimeMillis(); 
 long dt = t - time; 
 float secs = (float)dt / 1000.0f; // Convert to seconds 
 for (int i = 0; i < vehicles.size(); i++) { 
 Vehicle v = (Vehicle)vehicles.get(i); 
 v.update(secs); 
 } 
 
 // Check for collisions 
 
 for (int i = 0; i < vehicles.size(); i++) { 
 for (int j = i + 1; j < vehicles.size(); j++) { 
 Vehicle vi = (Vehicle)vehicles.get(i); 
 Vehicle vj = (Vehicle)vehicles.get(j); 
 if (vi.intersects(vj)) {  // Collision detected! 
 // For now, simply reset the positions of the vehicles 
 vi.updatePosition(50, 50); 
 vj.updatePosition(450, 450); 
 } 
 } 
 } 
 
 time = System.currentTimeMillis(); 
 game.repaint(); 
 
 // Sleep for a short amount of time to allow the system to catch up. 
 // This improves framerate substantially and avoids hiccups 
 
 try { 
 Thread.sleep(20); 
 } catch (InterruptedException e) { 
 } 
 } 
 } 
}