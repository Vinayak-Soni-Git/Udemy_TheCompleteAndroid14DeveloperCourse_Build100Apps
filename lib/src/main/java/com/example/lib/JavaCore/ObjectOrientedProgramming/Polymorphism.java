package com.example.lib.JavaCore.ObjectOrientedProgramming;

public class Polymorphism {
    public static void main(String[] args) {
        Vehicle v1 = new Car4(50,"BMW");
        Vehicle v2 = new Truck(6);

    }
}

class Truck extends Vehicle{

    public Truck(int numberOfWheels) {
        super(numberOfWheels);
    }

    @Override
    void brake() {
        System.out.println("Applying Hydraulic brake");
    }
}
