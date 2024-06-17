package com.example.lib.JavaCore.TenCodingExercise;

import java.util.Scanner;

public class Exercise9 {
    public static void main(String[] args) {
        int row, col, c, d;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the num of rows");
        row = scanner.nextInt();
        System.out.println("Enter the num of columns");
        col = scanner.nextInt();

        //Creating the matrices
        int array[][] = new int[row][col];
        int array2[][] = new int[row][col];
        int sum[][] = new int[row][col];

        //Getting the elements of matrix
        System.out.println("Enter the elements of 1st matrix");
        for (c = 0; c < row; c++) {
            for (d = 0; d < col; d++) {
                array[c][d] = scanner.nextInt();
            }
        }

        for (c = 0; c < row; c++) {
            for (d = 0; d < col; d++) {
                array2[c][d] = scanner.nextInt();
            }
        }

        // Making the addition of 2 matrices
        for (c = 0; c < row; c++) {
            for (d = 0; d < col; d++) {
                sum[c][d] = array[c][d]+ array2[c][d];
            }
        }

        // Displaying the result matrix
        for (c = 0; c < row; c++) {
            for (d = 0; d < col; d++) {
                System.out.println(sum[c][d]+ "\t");
            }
        }
    }
}
