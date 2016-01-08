/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbrush.Core;

import java.awt.Color;
import java.util.Vector;

/**
 *
 * @author dominick.nav
 */
abstract interface Renderable {
    public abstract boolean intersect(Ray r);
    public abstract Color Shade(Ray r, Vector lights, Vector objects, Color bgnd);
    public String toString();
}