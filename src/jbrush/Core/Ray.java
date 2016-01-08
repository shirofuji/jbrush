/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbrush.Core;

import java.awt.Color;
import java.util.Enumeration;
import java.util.Vector;

/**
 *
 * @author dominick.nav
 */
class Ray {
    public static final float MAX_T = Float.MAX_VALUE;
    Vector3d origin;
    Vector3d direction;
    float t;
    Renderable object;

    public Ray(Vector3d eye, Vector3d dir) {
        origin = eye.copy();
        direction = Vector3d.normalize(dir);
    }

    public boolean trace(Vector objects) {
        Enumeration objList = objects.elements();
        t = MAX_T;
        object = null;
        while (objList.hasMoreElements()) {
            Renderable object = (Renderable) objList.nextElement();
            object.intersect(this);
        }
        return (object != null);
    }

    public final Color Shade(Vector lights, Vector objects, Color bgnd) {
        return object.Shade(this, lights, objects, bgnd);
    }

    public String toString() {
        return ("ray origin = "+origin+"  direction = "+direction+"  t = "+t);
    }
}
