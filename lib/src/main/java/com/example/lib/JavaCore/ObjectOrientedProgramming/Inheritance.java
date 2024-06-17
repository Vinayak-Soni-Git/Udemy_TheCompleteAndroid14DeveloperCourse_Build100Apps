package com.example.lib.JavaCore.ObjectOrientedProgramming;

public class Inheritance {
    public static void main(String[] args) {

    }
}

class Car4 extends Vehicle{

    String carModel;



    public Car4(int numberOfWheels, String carModel) {
        super(numberOfWheels);
        this.carModel = carModel;
    }

    void honk(){
        System.out.println("Beep! Beep!");
    }

    //Method overriding
    @Override
    void start() {
        System.out.println("The car starts");
    }

    @Override
    void stop() {
        super.stop();
    }

    @Override
    void brake() {
        System.out.println("Applying mechanical brakes");
    }
}

