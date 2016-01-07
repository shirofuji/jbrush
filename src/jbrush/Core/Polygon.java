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
public class Polygon {
    public ArrayList<Vertex> vertices;
    public ArrayList<Edge> edges;
    public ArrayList<Pixel_3D> pixelBuffer;
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
}
