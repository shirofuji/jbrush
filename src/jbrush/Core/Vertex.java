/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbrush.Core;

/**
 *
 * @author Shirofuji
 */
public class Vertex {
    public double x = 0.00001;
    public double y = 0.00001;
    public double z = 0.00001;
    
    public double u;
    public double w;
    
    public Vertex(double x,double y,double z){
        this.x = x;
        this.y = y;
        this.z = z;
        if(x == 0) x = 0.00001;
        if(y == 0) y = 0.00001;
        if(z == 0) z = 0.00001;
    }
    public double distanceFrom(Vertex another){
        double z_squared;
        double y_squared;
        double x_squared;
        
        z_squared = Math.pow(another.z - this.z,2);
        y_squared = Math.pow(another.y - this.y,2);
        x_squared = Math.pow(another.x - this.x,2);
          
        return Math.sqrt((z_squared+x_squared+y_squared));
    } 
    public boolean collidesWith(Vertex v){
        if(
             this.x == v.x &&
             this.y == v.y &&
             this.z == v.z
            ){
                return true;
            }
        return false;
    }
    public void setLocation(double x, double y, double z){
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
} 
