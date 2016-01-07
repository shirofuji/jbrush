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
public class Edge {
    public ArrayList<Vertex> vertices;
    private float EPSILON = 0.001f;
    public Edge(Vertex vertexA, Vertex vertexB){
        this.vertices = new ArrayList<>();
        vertices.add(vertexA);
        vertices.add(vertexB);
    }
    
    public double length(){
        return vertices.get(1).distanceFrom(vertices.get(0));
    }
    
    private boolean intersectsXY(Vertex v){
        // (y2 - y1)=m(x2 - x1)
        Vertex vertexA = this.vertices.get(1);
        Vertex vertexB = this.vertices.get(0);
        double a = (vertexA.y - vertexB.y)/(vertexA.x - vertexB.x);
        double b = vertexA.y - (a*vertexA.x);
        return Math.abs(v.y - ((a*v.x)+b)) > this.EPSILON;
    }
    private boolean intersectsXZ(Vertex v){
        // (z2 - z1)=m(x2 - x1)
        Vertex vertexA = this.vertices.get(1);
        Vertex vertexB = this.vertices.get(0);
        double ax = (vertexA.z - vertexB.z)/(vertexA.x - vertexB.x);
        double bx = vertexA.z - (ax*vertexA.x);
        
        double ay = (vertexA.z - vertexB.z)/(vertexA.y - vertexB.y);
        double by = vertexA.z - (ay*vertexA.y);
        
        return (Math.abs(v.z - ((ax*v.x)+bx)) > this.EPSILON || Math.abs(v.z - ((ay*v.y)+by)) > this.EPSILON);
        
    }
    public boolean intersects(Vertex v){
        // (X0,y0,z0) = (x1,y1,z1) + t(x2-x1,y2-y1,z2-z1)
        Vector3d vert = new Vector3d((float)v.x,(float)v.y,(float)v.z);
        
        Vector3d pointA = new Vector3d((float)this.vertices.get(0).x,(float)this.vertices.get(0).y,(float)this.vertices.get(0).z);
        Vector3d pointB = new Vector3d((float)this.vertices.get(1).x,(float)this.vertices.get(1).y,(float)this.vertices.get(1).z);
        Vector3d midPoint = new Vector3d((pointA.x + pointB.x)/2,(pointA.y + pointB.y)/2,(pointA.z+ pointB.z)/2);
        
        // (x0,y0,z0) - (x1,y1,z1)
        Vector3d topEquation = vert.copy();
        topEquation.sub(pointA);
        
        //(x2-x1,y2-y1,z2-z1)
        Vector3d botEquation = pointB.copy();
        botEquation.sub(pointA);
        
        float tx = topEquation.x/botEquation.x;
        float ty = topEquation.y/botEquation.y;
        float tz = topEquation.z/botEquation.z;
        
        System.out.print(topEquation.toString()+",");
        System.out.print(botEquation.toString()+"\n");
        return (tx == ty && ty == tz && tz == tx);
        // return (this.intersectsXY(v) || this.intersectsXZ(v));
    }
}
