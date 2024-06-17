package com.example.lib.JavaCore.TenCodingExercise;

public class Exercise10 {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 5, 7, 9, 8};

        //Calculate the sum of all elements
        int sum = 0;
        for(int element: numbers){
            sum += element;
        }

        // calculate the average value
        double average = (double) sum/numbers.length;
        System.out.println("The average is:"+ average);
    }
}
