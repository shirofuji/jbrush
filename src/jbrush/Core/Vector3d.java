/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jbrush.Core;

/**
 *
 * @author dominick.nav
 */
public class Vector3d {
    /**
     * The x component of the vector.
     */
    public float x;
    /**
     * The y component of the vector.
     */
    public float y;
    /**
     * The z component of the vector.
     */
    public float z;
    
    /**
     * Constructor for a 3D vector.
     *
     * @param  x_ the x coordinate.
     * @param  y_ the y coordinate.
     * @param  z_ the y coordinate.
     */
    
    public Vector3d(float x_, float y_, float z_) {
        x = x_; y = y_; z = z_;
    }
    
    /**
     * Constructor for a 2D vector: z coordinate is set to 0.
     *
     * @param  x_ the x coordinate.
     * @param  y_ the y coordinate.
     */
    
    public Vector3d(float x_, float y_) {
        x = x_; y = y_; z = 0f;
    }
    
    /**
     * Constructor for an empty vector: x, y, and z are set to 0.
     */
    
    public Vector3d() {
        x = 0f; y = 0f; z = 0f;
    }
    
    /**
     * Set the x coordinate.
     *     
     *  @param  x_ the x coordinate.
     */
    
    public void setX(float x_) {
        x = x_;
    }
    
    /**
     * Set the y coordinate.
     *     
     *  @param  y_ the y coordinate.
     */
    public void setY(float y_) {
        y = y_;
    }
    
    /**
     * Set the z coordinate.
     *     
     *  @param  z_ the z coordinate.
     */
    public void setZ(float z_) {
        z = z_;
    }
    
    /**
     * Set x,y, and z coordinates.
     *     
     *  @param  x_ the x coordinate.
     *  @param  y_ the y coordinate.
     *  @param  z_ the z coordinate.
     */
    public void setXYZ(float x_, float y_, float z_) {
        x = x_;
        y = y_;
        z = z_;
    }
    
    /**
     * Set x,y, and z coordinates from a Vector3D object.
     *     
     *  @param  v the Vector3D object to be copied
     */
    public void setXYZ(Vector3d v) {
        x = v.x;
        y = v.y;
        z = v.z;
    }
    
    /**
     * Calculate the magnitude (length) of the vector
     * @return      the magnitude of the vector    
     */
    public float magnitude() {
        return (float) Math.sqrt(x*x + y*y + z*z);
    }
    
    /**
     * Copy the vector
     * @return      a copy of the vector   
     */
    public Vector3d copy() {
        return new Vector3d(x,y,z);
    }
    
    /**
     * Copy the vector
     * @param      v the vector to be copied   
     * @return      a copy of the vector   
     */
    public static Vector3d copy(Vector3d v) {
        return new Vector3d(v.x, v.y,v.z);
    }
    
    /**
     * Add a vector to this vector
     * @param      v the vector to be added  
     */   
    public void add(Vector3d v) {
        x += v.x;
        y += v.y;
        z += v.z;
    }
    
    /**
     * Subtract a vector from this vector
     * @param      v the vector to be subtracted  
     */   
    public void sub(Vector3d v) {
        x -= v.x;
        y -= v.y;
        z -= v.z;
    }
    
    /**
     * Multiply this vector by a scalar
     * @param      n the value to multiply by 
     */     
    public void mult(float n) {
        x *= n;
        y *= n;
        z *= n;
    }
    
    /**
     * Divide this vector by a scalar
     * @param      n the value to divide by 
     */     
    public void div(float n) {
        x /= n;
        y /= n;
        z /= n;
    }
    
    
    /**
     * Calculate the dot product with another vector
     * @return  the dot product
     */     
    public float dot(Vector3d v) {
        float dot = x*v.x + y*v.y + z*v.z;
        return dot;
    }
    
    /**
     * Calculate the cross product with another vector
     * @return  the cross product
     */     
    public Vector3d cross(Vector3d v) {
        float crossX = y * v.z - v.y * z;
        float crossY = z * v.x - v.z * x;
        float crossZ = x * v.y - v.x * y;
        return(new Vector3d(crossX,crossY,crossZ));
    }
    
    /**
     * Normalize the vector to length 1 (make it a unit vector)
     */     
    public void normalize() {
        float m = magnitude();
        if (m > 0) {
            div(m);
        }
    }
    
    public final static Vector3d normalize(Vector3d A) {
        float t = A.x*A.x + A.y*A.y + A.z*A.z;
        if (t != 0 && t != 1) t = (float)(1 / Math.sqrt(t));
        return new Vector3d(A.x*t, A.y*t, A.z*t);
    }
    /**
     * Limit the magnitude of this vector
     * @param max the maximum length to limit this vector
     */     
    public void limit(float max) {
        if (magnitude() > max) {
            normalize();
            mult(max);
        }
    }
    
    /**
     * Calculate the angle of rotation for this vector (only 2D vectors)
     * @return the angle of rotation
     */    
    public float heading2D() {
        float angle = (float) Math.atan2(-y, x);
        return -1*angle;
    }
    
    /**
     * Rotates a 2D Vector
     * @param theta, angle in radians to rotate vector
     */    
    public void rotate2D(float theta) {
        float currentTheta = heading2D();
        float mag = magnitude();
        currentTheta += theta;
        x = (float) (mag*Math.cos(currentTheta));
        y = (float) (mag*Math.sin(currentTheta));
    }
    
  
    /**
     * Add two vectors
     * @param      v1 a vector
     * @param v2 another vector   
     * @return a new vector that is the sum of v1 and v2  
     */   
    public static Vector3d add(Vector3d v1, Vector3d v2) {
        Vector3d v = new Vector3d(v1.x + v2.x,v1.y + v2.y, v1.z + v2.z);
        return v;
    }
    
    /**
     * Subtract one vector from another
     * @param      v1 a vector
     * @param v2 another vector   
     * @return a new vector that is v1 - v2 
     */    
    public static Vector3d sub(Vector3d v1, Vector3d v2) {
        Vector3d v = new Vector3d(v1.x - v2.x,v1.y - v2.y,v1.z - v2.z);
        return v;
    }
    
    /**
     * Divide a vector by a scalar
     * @param      v1 a vector
     * @param n scalar 
     * @return a new vector that is v1 / n
     */ 
    public static Vector3d div(Vector3d v1, float n) {
        Vector3d v = new Vector3d(v1.x/n,v1.y/n,v1.z/n);
        return v;
    }
    
    /**
     * Multiply a vector by a scalar
     * @param      v1 a vector
     * @param n scalar 
     * @return a new vector that is v1 * n
     */ 
    public static Vector3d mult(Vector3d v1, float n) {
        Vector3d v = new Vector3d(v1.x*n,v1.y*n,v1.z*n);
        return v;
    }
    
    /**
     * Rotates a 2D Vector
     * @param theta, angle in radians to rotate vector
     * @return a new Vector object, rotated by theta
     */    
    public static Vector3d rotate2D(Vector3d v, float theta) {
        // What is my current heading
        float currentTheta = v.heading2D();
        // What is my current speed
        float mag = v.magnitude();
        // Turn me
        currentTheta += theta;
        // Look, polar coordinates to cartesian!!
        Vector3d newV = new Vector3d((float) (mag*Math.cos(currentTheta)),(float) (mag*Math.cos(currentTheta)));
        return  newV;
    }
    
    /**
     * Calculate the Euclidean distance between two points (considering a point as a vector object)
     * @param      v1 a vector
     * @param v2 another vector
     * @return the Euclidean distance between v1 and v2
     */ 
    public static float distance (Vector3d v1, Vector3d v2) {
        float dx = v1.x - v2.x;
        float dy = v1.y - v2.y;
        float dz = v1.z - v2.z;
        return (float) Math.sqrt(dx*dx + dy*dy + dz*dz);
    }
    
    /**
     * Calculate the angle between two vectors, using the dot product
     * @param      v1 a vector
     * @param v2 another vector
     * @return the angle between the vectors
     */ 
    public static float angleBetween(Vector3d v1, Vector3d v2) {
        float dot = v1.dot(v2);
        float theta = (float) Math.acos(dot / (v1.magnitude() * v2.magnitude()));
        return theta;
    }
    
    public String toString(){
        String out = "(";
        out += Double.toString(x);
        out += ",";
        out += Double.toString(y);
        out += ",";
        out += Double.toString(z);
        out += ")";
        return out;
    }
}