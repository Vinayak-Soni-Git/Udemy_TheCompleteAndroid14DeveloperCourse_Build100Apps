package com.example.lib.JavaCore.ConditionalStatements;

public class BreakAndContinueKeywords {
    public static void main(String[] args) {
        for (int i=0;i<10;i++){
            if (i == 4){
                break;
            }
            System.out.println(i);
        }

        for (int i=0;i<10;i++){
            if (i == 4){
                continue;
            }
            System.out.println(i);
        }
    }
}
