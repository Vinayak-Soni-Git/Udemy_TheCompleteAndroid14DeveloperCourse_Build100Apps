package com.example.lib.JavaCore.ConditionalStatements;

public class SwitchStatement {
    public static void main(String[] args) {
        int dayOfWeek = 1;

        switch(dayOfWeek){
            case 1:
                System.out.println("monday");
                break;
            case 2:
                System.out.println("tuesday");
                break;
            case 3:
                System.out.println("wednesday");
                break;
            default:
                System.out.println("sunday");
                break;
        }
    }
}
