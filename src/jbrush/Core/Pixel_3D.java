/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbrush.Core;

/**
 *
 * @author dominick.nav
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
/**
 *
 * @author Shirofuji
 */
public class Pixel_3D {
    double x;
    double y;
    double z;
    
    double r = 0;
    double g = 0;
    double b = 0;
    
    public Pixel_3D(double x,double y,double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Pixel_3D(Vertex v){
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }
    public void setColor(double r,double g,double b){
        this.r = r;
        this.g = g;
        this.b = b;
    }
    public void log(){
        System.out.print("pixel3d(");
        System.out.print(this.x);
        System.out.print(",");
        System.out.print(this.y);
        System.out.print(",");
        System.out.print(this.z);
        System.out.print(")\n");
    }
}










