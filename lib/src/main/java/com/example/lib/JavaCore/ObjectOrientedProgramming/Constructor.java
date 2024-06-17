package com.example.lib.JavaCore.ObjectOrientedProgramming;

public class Constructor {
    public static void main(String[] args) {
        Car3 redCar = new Car3(50, 2023);
        redCar.accelerate();
        redCar.brake();
    }
}

class Car3{
    int year;
    int speed;

    public Car3(int speed, int year){
        this.speed = speed;
        this.year = year;
    }


    void accelerate(){
        speed += 10;
        System.out.println("Your new speed is: "+ speed);
    }

    void brake(){
        speed -= 5;
        System.out.println("Your new speed is: "+ speed);
    }
}