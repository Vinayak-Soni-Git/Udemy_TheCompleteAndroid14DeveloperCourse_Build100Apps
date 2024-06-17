package com.example.lib.JavaCore.RepetationalStatements;

public class ForLoop {
    public static void main(String[] args) {
        for (int i =1;i<=5;i++){
            System.out.print(i+" ");
        }

        int arr[] = {1, 2, 3, 4, 5};

        for ( int i = 0; i < arr.length - 2; ++i)
            System.out.println(arr[i] + " ");
    }
}
