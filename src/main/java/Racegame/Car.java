/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Racegame;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import java.awt.image.ImageObserver;
import javax.swing.ImageIcon;
import javax.swing.text.Position;

/**
 *
 * @author jeroen
 */
public class Car extends Vehicle implements ImageObserver{
    protected Image img;
    protected float w2;
    protected float h2;

    public Car(String imageFileName) {
        ImageIcon ii = new ImageIcon(imageFileName);
        img = Transparency.makeColorTransparent(ii.getImage(), Color.BLACK);
        
    }
    
    
    @Override
    public void draw(Graphics2D g2) {
        AffineTransform saveXform = g2.getTransform();
        
        g2.translate(position.x, position.y);
        g2.rotate(Math.atan2(orientation.y, orientation.x));
        g2.drawImage(img, AffineTransform.getTranslateInstance(-img.getWidth(this)/2.0, -img.getHeight(this)/2.0),
                this);
        
        g2.setTransform(saveXform);
    }

    @Override
    public boolean intersects(Vehicle v) {
        if (v instanceof Car) { 
 Car c = (Car)v; 
 Point2D.Float d = new Point2D.Float(position.x - c.position.x, position.y - c.position.y); 
 if (length(d) < 25.0f) { // Should probably compute the radius from the images instead... 
 return true; 
 } 
 } 
 return false; 
 } 

   public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height) { 
    return true; 
 } 
}
