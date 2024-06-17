package com.example.lib.JavaCore.DataTypes.NonPermitive;

public class MultiDimensionalArrays {
    public static void main(String[] args) {
        int[][] myMatrix = new int[3][3];

        myMatrix[0][0] = 1;
        myMatrix[0][1] = 2;
        myMatrix[0][2] = 3;

        myMatrix[1][0] = 4;
        myMatrix[1][1] = 5;
        myMatrix[1][2] = 6;

        myMatrix[2][0] = 7;
        myMatrix[2][1] = 8;
        myMatrix[2][2] = 9;

        System.out.println(myMatrix[2][0]);

        int[][] myMatrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
    }
}
