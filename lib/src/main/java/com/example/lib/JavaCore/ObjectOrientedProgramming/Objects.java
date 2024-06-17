package com.example.lib.JavaCore.ObjectOrientedProgramming;

public class Objects {

    public static void main(String[] args) {
        Car2 redCar = new Car2();
        redCar.speed = 180;
        redCar.year = 2023;

        redCar.accelerate();
        redCar.brake();
    }
}

class Car2{
    int year;
    int speed;

    void accelerate(){
        speed += 10;
        System.out.println("Your new speed is: "+ speed);
    }
    void brake(){
        speed -= 5;
        System.out.println("Your new speed is: "+ speed);
    }

}
