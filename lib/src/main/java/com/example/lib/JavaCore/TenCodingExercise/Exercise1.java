package com.example.lib.JavaCore.TenCodingExercise;

import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first number");
        int number1 = scanner.nextInt();
        System.out.println("Enter the second number");
        int number2 = scanner.nextInt();

        float d = (float) number1/number2;
        float r = number1 % number2;

        System.out.println("The division result is: "+ d);
        System.out.println("The remainder is: "+r);
    }
}
