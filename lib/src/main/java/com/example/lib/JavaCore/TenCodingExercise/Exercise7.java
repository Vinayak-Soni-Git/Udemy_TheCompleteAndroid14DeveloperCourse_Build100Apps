package com.example.lib.JavaCore.TenCodingExercise;

public class Exercise7 {
    public static void main(String[] args) {
        int[] numbers = {5, 7, 2, 4, 9};
        int evenNumbers = 0;
        int oddNumbers = 0;

        for (int i=0;i<numbers.length;i++){
            if(numbers[i] % 2 == 0){
                evenNumbers++;
            }
            else{
                oddNumbers++;
            }
        }
        System.out.println("The number of even numbers: "+ evenNumbers);
        System.out.println("The number of odd numbers: "+ oddNumbers);

    }
}
