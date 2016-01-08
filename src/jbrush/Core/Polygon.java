/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbrush.Core;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Vector;
/**
 *
 * @author Shirofuji
 */
public class Polygon implements Renderable{
    public ArrayList<Vertex> vertices;
    public ArrayList<Edge> edges;
    public ArrayList<Pixel_3D> pixelBuffer;
    public Surface s;
    public Vector3d plane;
    
    private int default_color = 0xD3D3D3;
    private Integer color = null;
    public Polygon(Vertex A, Vertex B, Vertex C, Vertex D){
        this.vertices = new ArrayList<>();
        this.edges = new ArrayList<>();
        this.vertices.add(A);
        this.vertices.add(B);
        this.vertices.add(C);
        this.vertices.add(D);
        this.edges.add(new Edge(this.vertices.get(0), this.vertices.get(1)));
        this.edges.add(new Edge(this.vertices.get(1), this.vertices.get(2)));
        this.edges.add(new Edge(this.vertices.get(2), this.vertices.get(3)));
        this.edges.add(new Edge(this.vertices.get(3), this.vertices.get(1)));
    }
    
    public Vector3d getNormalVector(){
        Vector3d a;
        Vector3d b;
        Vector3d c;
        a = new Vector3d(this.vertices.get(0));
        b = new Vector3d(this.vertices.get(1));
        c = new Vector3d(this.vertices.get(2));
        
        Vector3d ab = a.copy();
        ab.sub(b);
        Vector3d bc = c.copy();
        bc.sub(b);
        
        Vector3d cross = ab.cross(bc);
        
        return cross;
    }
    
    public Vector3d getCenter(){
        Vector3d a = new Vector3d(this.vertices.get(0));
        Vector3d b = new Vector3d(this.vertices.get(1));
        Vector3d c = new Vector3d(this.vertices.get(2));
        Vector3d d = new Vector3d(this.vertices.get(3));
        
        Vector3d ab = a.copy();
        a.sub(b);
        
        Vector3d cd = c.copy();
        c.sub(d);
        
        Vector3d abcd = ab.copy();
        abcd.sub(cd);
        return abcd;
    }
    public void scanlineFill(){
        pixelBuffer = new ArrayList<>();
        boolean fill = false;
        for(double x = this.getXMin(); x <= this.getXMax(); x++){
            for(double y = this.getYMin(); y<= this.getYMax(); y++){
                for(double z = this.getZMin(); z<=this.getZMax(); z++){
                    Vertex v = new Vertex(x,y,z);
                    for(Edge e: this.edges){
                        if(e.intersects(v)){
                            fill = !fill;
                            if(fill){
                                pixelBuffer.add(new Pixel_3D(v));
                            }
                        }
                    }
                }
            }
        }
    }
    
    public double getYMax(){
        int count = this.vertices.size();
        double yMax = 0;
        for(int i = 0;i<count;i++){
            if(i == 0){
                yMax = this.vertices.get(i).y;
            }else{
                double current_y = this.vertices.get(i).y;
                if(current_y > yMax){
                    yMax = current_y;
                }
            }
        }
        return yMax;
    }
    public double getYMin(){
        int count = this.vertices.size();
        double yMin = 0;
        for(int i = 0;i<count;i++){
            if(i == 0){
                yMin = this.vertices.get(i).y;
            }else{
                double current_y = this.vertices.get(i).y;
                if(current_y < yMin){
                    yMin = current_y;
                }
            }
        }
        return yMin;
    }
    public double getXMax(){
        int count = this.vertices.size();
        double xMax = 0;
        for(int i = 0;i<count;i++){
            if(i == 0){
                xMax = this.vertices.get(i).x;
            }else{
                double current_x = this.vertices.get(i).x;
                if(current_x > xMax){
                    xMax = current_x;
                }
            }
        }
        return xMax;
    }
    public double getXMin(){
        int count = this.vertices.size();
        double xMin = 0;
        for(int i = 0;i<count;i++){
            if(i == 0){
                xMin = this.vertices.get(i).x;
            }else{
                double current_x = this.vertices.get(i).x;
                if(current_x < xMin){
                    xMin = current_x;
                }
            }
        }
        return xMin;
    }
    public double getZMax(){
        int count = this.vertices.size();
        double zMax = 0;
        for(int i = 0;i<count;i++){
            if(i == 0){
                zMax = this.vertices.get(i).z;
            }else{
                double current_z = this.vertices.get(i).z;
                if(current_z > zMax){
                    zMax = current_z;
                }
            }
        }
        return zMax;
    }
    public double getZMin(){
        int count = this.vertices.size();
        double zMin = 0;
        for(int i = 0;i<count;i++){
            if(i == 0){
                zMin = this.vertices.get(i).z;
            }else{
                double current_z = this.vertices.get(i).z;
                if(current_z < zMin){
                    zMin = current_z;
                }
            }
        }
        return zMin;
    }

    @Override
    public boolean intersect(Ray r) {
        Vector3d normal = this.getNormalVector();
        Vector3d center = this.getCenter();
        float denom = normal.dot(r.direction);
        if(Math.abs(denom) > 0.0001f){
            center.sub(new Vector3d(this.vertices.get(0)));
            float t=center.dot(normal);
            if(t >= 0f) return true;
        }
        return false;
    }

    @Override
    public Color Shade(Ray r, Vector lights, Vector objects, Color bgnd) {
        float px = r.origin.x + r.t*r.direction.x;
        float py = r.origin.y + r.t*r.direction.y;
        float pz = r.origin.z + r.t*r.direction.z;
        
        Vector3d center= this.getCenter();
        Vector3d p = new Vector3d(px,py,pz);
        Vector3d v = new Vector3d(-r.direction.x,-r.direction.y,-r.direction.z);
        Vector3d n = new Vector3d(px - center.x,py - center.y,pz-center.z);
        return s.Shade(p, v, v, lights, objects, bgnd);
    }
}
