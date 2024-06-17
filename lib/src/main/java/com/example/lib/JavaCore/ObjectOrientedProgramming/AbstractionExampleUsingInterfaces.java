package com.example.lib.JavaCore.ObjectOrientedProgramming;

public class AbstractionExampleUsingInterfaces {
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        Rectangle rectangle = new Rectangle(4.0, 4.0);
    }
}


class Circle{
    private final double radius;

    public Circle(double radius){
        this.radius = radius;
    }

    public double calculateArea(){
        return 3.14*radius*radius;
    }

    public double calculatePerimeter(){
        return 2*3.14*radius;
    }
}


class Rectangle implements Shape{
    private final double length;
    private final double width;

    public Rectangle(double length, double width){
        this.length = length;
        this.width = width;
    }

    public double calculateArea(){
        return length * width;
    }

    public double calculatePerimeter(){
        return 2*(length*width);
    }
}

class Square implements Shape{

    @Override
    public double calculateArea() {
        return 0;
    }

    @Override
    public double calculatePerimeter() {
        return 0;
    }
}