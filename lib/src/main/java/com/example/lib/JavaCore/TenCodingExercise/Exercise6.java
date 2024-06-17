package com.example.lib.JavaCore.TenCodingExercise;

public class Exercise6 {
    public static void main(String[] args) {
        int[] arr = {1, 3, -5, 4};
        int[] arr2 = {1, 4, -5, -2};

        System.out.println();
        String result = "";

        for(int i=0;i<arr.length;i++){
            int num1 = arr[i];
            int num2 = arr2[i];

            result += (num1*num2) +" ";
         }
        System.out.println("\nResult: "+result);
    }
}
