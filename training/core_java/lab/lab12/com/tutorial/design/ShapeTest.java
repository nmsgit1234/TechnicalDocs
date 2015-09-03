package com.tutorial.design;

import com.tutorial.shapes.Circle;
import com.tutorial.shapes.Rectangle;
 
public class ShapeTest {
 
    public static void main(String[] args) {
         
        //programming for interfaces not implementation
        Shape shape = new Circle(10);
         
        shape.draw();
        System.out.println("Area="+shape.getArea());
         
        //switching from one implementation to another easily
        shape=new Rectangle(10,10);
        shape.draw();
        System.out.println("Area="+shape.getArea());
        }
 
}