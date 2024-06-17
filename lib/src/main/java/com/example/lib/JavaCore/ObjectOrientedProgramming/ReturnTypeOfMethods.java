package com.example.lib.JavaCore.ObjectOrientedProgramming;

public class ReturnTypeOfMethods {
    public static void main(String[] args) {
        int result = addNumbers();
        System.out.println(result);

        String name = getName();
        System.out.println(name);
    }

    static int addNumbers(){
        return 10+20;
    }

    static String getName(){
        return "name";
    }
}
