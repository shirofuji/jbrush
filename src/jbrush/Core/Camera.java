/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbrush.Core;

import java.util.ArrayList;

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
    
    public double far = 20;
    
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
           // ArrayList<Point2D> screen_points = new ArrayList<>();
            poly.vertices.stream().forEach((Vertex vert) -> {
                double projectedX;
                double projectedY;
                if(vert.z == 0) vert.z = 0.00001; 
                projectedX = (vert.x - this.x) * (this.far / vert.z) + Camera.this.x;
                projectedY = (vert.y - this.y) * (this.far / vert.z) + Camera.this.y;
//                screen_points.add(new Point2D(projectedX, projectedY));
            });
            String svg_path = "M";
//            for(Point2D point: screen_points){
//                if(svg_path == "M"){
//                    String start = point.x+" "+point.y;
//                    svg_path += start;
//                }else{
//                    String line = "L"+point.x+" "+point.y;
//                    svg_path += line;
//                }
//            }
            svg_path += "Z";
            System.out.println(svg_path);
        }
    }
}
