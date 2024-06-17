package com.example.lib.JavaCore.TenCodingExercise;

import java.util.Scanner;

public class Exercise4 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        count(inputString);
    }

    public static void count(String inputString){
        char[] chars = inputString.toCharArray();
        int letter = 0, spaces=0, digits=0, others=0;

        for (int i=0;i<inputString.length();i++){
            if (Character.isLetter(chars[i])){
                letter++;
            } else if (Character.isDigit(chars[i])){
                digits++;
            } else if (Character.isSpaceChar(chars[i])){
                spaces++;
            } else {
                others++;
            }
        }
        System.out.println("Letters: "+ letter);
        System.out.println("Numbers:"+ digits);
        System.out.println("Spaces:"+ spaces);
        System.out.println("Others:"+ others);

    }
}
