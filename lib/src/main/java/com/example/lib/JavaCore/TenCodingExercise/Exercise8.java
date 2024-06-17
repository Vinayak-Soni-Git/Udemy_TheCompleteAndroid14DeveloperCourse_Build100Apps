package com.example.lib.JavaCore.TenCodingExercise;

import java.util.Scanner;

public class Exercise8 {
    public static void main(String[] args) {
        int i, j, x, n=5, s;
//        System.out.println("Please enter a number");
//        Scanner scanner = new Scanner(System.in);
//        n = scanner.nextInt();

        s = n+4-1;

        for (i = 1;i<=n;i++){
            for (x = s;x!=0;x--){
                System.out.print(" ");
            }
            for (j=1;j<=i;j++){
                System.out.print(i+" ");
            }
            System.out.println();
            s--;
        }
    }
}
