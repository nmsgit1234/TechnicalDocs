package com.tutorial.shapes;
 
import com.tutorial.design.Shape; 
public class Rectangle implements Shape {
 
    private double width;
    private double height;
     
    public Rectangle(double w, double h){
        this.width=w;
        this.height=h;
    }
    
	public void draw() {
        System.out.println("Drawing Rectangle");
    }
 
    public double getArea() {
        return this.height*this.width;
    }
 
}