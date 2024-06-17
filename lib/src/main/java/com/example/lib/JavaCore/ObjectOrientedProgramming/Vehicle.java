package com.example.lib.JavaCore.ObjectOrientedProgramming;

public abstract class Vehicle {
    int numberOfWheels;

    public Vehicle(int numberOfWheels){
        this.numberOfWheels = numberOfWheels;
    }

    void start(){
        System.out.println("The Vehicle starts");
    }

    void stop(){
        System.out.println("The vehicle stops");
    }

    abstract void brake();
}
