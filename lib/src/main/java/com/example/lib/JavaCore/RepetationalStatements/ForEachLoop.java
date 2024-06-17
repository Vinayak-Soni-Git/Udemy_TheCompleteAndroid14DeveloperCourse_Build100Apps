package com.example.lib.JavaCore.RepetationalStatements;

public class ForEachLoop {
    public static void main(String[] args) {
        int[] numbersArray = new int[5];

        numbersArray[0] = 10;
        numbersArray[1] = 20;
        numbersArray[2] = 30;
        numbersArray[3] = 40;
        numbersArray[4] = 50;

        for (int element: numbersArray){
            System.out.print(element+" ");
        }
    }
}
