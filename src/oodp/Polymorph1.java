/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oodp;

/**
 *
 * @author pga
 */
public class Polymorph1 {
   public static void main(String argv[]) {
   
      // create some shape instances
      Shape scribble[] = new Shape[2];
      scribble[0] = new Rectangle(10, 20, 5, 6);
      scribble[1] = new Circle(15, 25, 8);
   
      // iterate through the list and handle shapes polymorphically
      for (int i = 0; i < scribble.length; i++) {
         scribble[i].draw();
         scribble[i].rMoveTo(100, 100);
         scribble[i].draw();
      }
   
      // call a rectangle specific function
      Rectangle arect = new Rectangle(0, 0, 15, 15);
      arect.setWidth(30);
      arect.draw();
   }
}
class Circle extends Shape {
   private int radius;

   // constructor
   Circle(int newx, int newy, int newradius) {
      super(newx, newy);
      setRadius(newradius);
   }

   // accessors for the radius
   int getRadius() { 
      return radius; }
   void setRadius(int newradius) { radius = newradius; }

   // draw the circle
   void draw() {
      System.out.println("Drawing a Circle at:(" + getX() + ", " + getY() +
         "), radius " + getRadius());
   }
}
abstract class Shape {
   private int x;
   private int y;

   // constructor
   Shape(int newx, int newy) {
      moveTo(newx, newy);
   }

   // accessors for x & y
   int getX() { 
      return x; }
   int getY() { 
      return y; }
   void setX(int newx) { x = newx; }
   void setY(int newy) { y = newy; }

   // move the x & y position
   void moveTo(int newx, int newy) {
      setX(newx);
      setY(newy);
   }
   void rMoveTo(int deltax, int deltay) {
      moveTo(getX() + deltax, getY() + deltay);
   }

   // virtual draw method
   abstract void draw();
}
class Rectangle extends Shape {
   private int width;
   private int height;

   // constructor
   Rectangle(int newx, int newy, int newwidth, int newheight) {
      super(newx, newy);
      setWidth(newwidth);
      setHeight(newheight);
   }

   // accessors for the width & height
   int getWidth() { 
      return width; }
   int getHeight() { 
      return height; }
   void setWidth(int newwidth) { width = newwidth; }
   void setHeight(int newheight) { height = newheight; }

   // draw the rectangle
   void draw() {
      System.out.println("Drawing a Rectangle at:(" + getX() + ", " + getY() +
         "), width " + getWidth() + ", height " + getHeight());
   }
}
