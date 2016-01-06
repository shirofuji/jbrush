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
    public double x;
    public double y;
    public double z;
    
    public double u;
    public double w;
    
    public Vertex(double x,double y,double z){
        this.x = x;
        this.y = y;
        this.z = z;
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
    
    public void setLocation(double x, double y, double z){
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
}
