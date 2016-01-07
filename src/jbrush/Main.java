/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbrush;

import jbrush.Core.*;
/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // JBrushWindow appWindow;
        // appWindow = new JBrushWindow("JBrush");
        // appWindow.show();
        Polygon poly = new Polygon(
            new Vertex(3,1,3),
            new Vertex(3,1,1),
            new Vertex(1,2,1),
            new Vertex(1,2,3)
            );
        poly.scanlineFill();
        for(Pixel_3D pixel: poly.pixelBuffer){
            pixel.log();
        }
    }
    
}
