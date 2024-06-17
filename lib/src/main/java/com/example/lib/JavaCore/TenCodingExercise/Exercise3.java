package com.example.lib.JavaCore.TenCodingExercise;

import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        int decimalNumber, quot, i = 1, j;

        int[] binaryNumber = new int[100];
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the decimal number");
        decimalNumber = scanner.nextInt();

        quot = decimalNumber;
        while (quot != 0) {
            binaryNumber[i++] = quot % 2;
            quot = quot / 2;
        }
        System.out.println("Binary number is: ");
        for (j = i - 1; j > 0; j--) {
            System.out.println(binaryNumber[j]);
        }
        System.out.println();
    }
}
