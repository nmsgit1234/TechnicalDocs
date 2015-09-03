package com.tutorial.shapes;

import com.tutorial.design.Shape;
public class Circle implements Shape {
 
    private double radius;
 
    public Circle(double r){
        this.radius = r;
    }
     
    public void draw() {
        System.out.println("Drawing Circle");
    }
     
    public double getArea(){
        return Math.PI*this.radius*this.radius;
    }
 
    public double getRadius(){
        return this.radius;
    }
}