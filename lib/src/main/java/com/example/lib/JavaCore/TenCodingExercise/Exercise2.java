package com.example.lib.JavaCore.TenCodingExercise;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter a radius");
        int radius = scanner.nextInt();

        float perimeter = (float) ((float)2*3.14*radius);
        float area = (float) Math.PI*radius*radius;

        System.out.println("Perimeter: "+ perimeter +" "+"Area: "+ area);

    }
}
