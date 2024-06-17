package com.example.lib.JavaCore.TenCodingExercise;

import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Input the String");
        char[] letters = scanner.nextLine().toCharArray();

        System.out.println("The reversed String is:");
        for (int i=letters.length-1;i>=0;i--){
            System.out.println(letters[i]);
        }
    }
}
