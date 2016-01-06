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
public class Camera {
    public double x;
    public double y;
    public double z;
    
    private double look_x;
    private double look_y;
    private double look_z;
    
    public double near;
    public double far;
    
    private boolean perspective = false;
    
    public Camera(double x,double y,double z,double lx,double ly,double lz){
        this.x = x;
        this.y = y;
        this.z = z;
        this.look_x = lx;
        this.look_y = ly;
        this.look_z = lz;
    }
    public void setPerspective(boolean toggle){
        this.perspective = toggle;
    }
    public boolean getPerspective(){ return this.perspective; }
    
    public void setLocation(double x,double y,double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void focus(double x,double y,double z){
        this.look_x = x;
        this.look_y = y;
        this.look_z = z;
    }
    public void project(Polygon poly){
        if(this.perspective){
            
        }else{
            
        }
    }
}
