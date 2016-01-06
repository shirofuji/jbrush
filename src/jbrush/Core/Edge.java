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
    public Edge(Vertex vertexA, Vertex vertexB){
        vertices.add(vertexA);
        vertices.add(vertexB);
    }
    public double length(){
        return vertices.get(1).distanceFrom(vertices.get(0));
    }
}
