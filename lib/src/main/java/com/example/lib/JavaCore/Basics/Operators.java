package com.example.lib.JavaCore.Basics;

public class Operators {
    public static void main(String[] args) {
        // Arithmetic operators + - * / %
        System.out.println(1+2);
        System.out.println(4*4);
        System.out.println(10/5);
        System.out.println(10%5);


        // Comparison Operators == != > < >= <=
        int x = 10;
        System.out.println(x == 9);
        System.out.println(x != 10);
        System.out.println(x > 1000);
        System.out.println(x >= 10);

        // Logical Operators: && || !
        boolean isSunny = true;
        boolean needUmbrella = false;

        boolean shouldGoOutside = isSunny && !needUmbrella;
        boolean canPlayGames = isSunny || needUmbrella;

        System.out.println(shouldGoOutside);



    }
}
