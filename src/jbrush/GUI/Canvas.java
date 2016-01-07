/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbrush.GUI;

import javax.swing.JEditorPane;

/**
 *
 * @author dominick.nav
 */
public class Canvas extends JEditorPane{
    public Canvas(){
        this.setContentType("text/html");
        this.setEditable(false);
    }
    
    public void render(String svg){
        this.setText(svg);
    }
}
