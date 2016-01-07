/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbrush;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
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
        JBrushWindow appWindow;
        appWindow = new JBrushWindow("JBrush");
        appWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        appWindow.setSize(1024,768);
        appWindow.setVisible(true);
        Camera cam = new Camera(200,100,100,appWindow.getWidth()/2,appWindow.getHeight()/2,5);
        Polygon poly = new Polygon(
            new Vertex(500,800,800),
            new Vertex(500,800,500),
            new Vertex(800,800,500),
            new Vertex(800,800,800)
            );
        poly.scanlineFill();
        ArrayList<Point2D> pixelBuffer = new ArrayList<>();
        for(Pixel_3D pixel: poly.pixelBuffer){
            Point2D projectedPixel = cam.project(pixel);
            Graphics g = appWindow.getGraphics();
            g.setColor(Color.GRAY);
            g.fillRect((int)projectedPixel.x,(int)projectedPixel.y,(int)projectedPixel.x+1,(int)projectedPixel.y+1);
            appWindow.paint(g);
        }
    }
    
}
