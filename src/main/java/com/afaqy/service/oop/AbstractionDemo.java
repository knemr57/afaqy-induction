package com.afaqy.service.oop;

interface Shape {

    double area();

}

class Circle implements Shape {

    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

}

class Rectangle implements Shape {

    double length;
    double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }

}

public class AbstractionDemo {

    public static void main(String[] args) {
        Shape circle = new Circle(2.2);
        Shape rectangle = new Rectangle(2, 4);

        System.out.println("Circle area is : " + circle.area());
        System.out.println("Rectangle area is : " + rectangle.area());
    }

}
