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



public class Driving implements Runnable{

    protected GameWorld game;
    
    public Driving(GameWorld gameworld){
        game = gameworld;
    }
    
    public void run() {
        long time = System.currentTimeMillis();
        //oneindige for lus gedurende het spel
        
        for(;;){
            ArrayList vehicles = game.getVehicles();
            
            // update position of vehicles
            
            long t = System.currentTimeMillis();
            long dt = t-time;
            float secs = (float) dt/1000.0f; //convert long timestamp to seconds
            for(int i= 0; i<vehicles.size();i++){
                Vehicle v = (Vehicle) vehicles.get(i);
                v.update(secs);
            }
            
            
            
        }
        
        
    }
   
}
