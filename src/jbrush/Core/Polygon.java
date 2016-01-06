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
    public ArrayList<Edge> edges;
    private int default_color = 0xD3D3D3;
    private Integer color = null;
    public Polygon(Edge edgeA,Edge edgeB,Edge edgeC,Edge edgeD) throws Exception{
        if(edgeA.vertices.get(0).distanceFrom(edgeB.vertices.get(0)) != 0 || 
            edgeA.vertices.get(0).distanceFrom(edgeB.vertices.get(0)) != 0){
            throw new Exception("First edge should share a common vertex with the second edge.");
        }
        else if(edgeB.vertices.get(0).distanceFrom(edgeC.vertices.get(0)) != 0 || 
            edgeB.vertices.get(0).distanceFrom(edgeC.vertices.get(0)) != 0){
            throw new Exception("Second edge should share a common vertex with the third edge.");
        }
        else if(edgeC.vertices.get(0).distanceFrom(edgeD.vertices.get(0)) != 0 || 
            edgeC.vertices.get(0).distanceFrom(edgeD.vertices.get(0)) != 0){
            throw new Exception("Third edge should share a common vertex with the fourth edge.");
        }
        else if(edgeD.vertices.get(0).distanceFrom(edgeD.vertices.get(0)) != 0 || 
            edgeD.vertices.get(0).distanceFrom(edgeD.vertices.get(0)) != 0){
            throw new Exception("Last edge should share a common vertex with the first edge.");
        }else{
           edges.add(edgeA);
           edges.add(edgeB);
           edges.add(edgeC);
           edges.add(edgeD);   
        }
    }
    public int getColor(){
        if(color == null){
            return default_color;
        }else{
            return color;
        }
    }
}
