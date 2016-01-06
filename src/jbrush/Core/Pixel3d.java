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
public class Pixel3D {
    double x;
    double y;
    double z;
    
    double r = 0;
    double g = 0;
    double b = 0;
    
    public Pixel3D(x,y,z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public void setColor(r,g,b){
        this.r = r;
        this.g = g;
        this.b = b;
    }
    public void log(){
        system.out.print("pixel3d(");
        system.out.print(this.x);
        system.out.print(",");
        system.out.print(this.y);
        system.out.print(",");
        system.out.print(this.z);
        system.out.print(")\n");
    }
}









