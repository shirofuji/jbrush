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
        return (this.intersectsXY(v) || this.intersectsXZ(v));
    }
}
