package com.example.lib.JavaCore.TypeCasting;

public class TypeCasting {

    // Type casting: is the precess of converting
    // a value from one data type to another

    // Implicit type casting
    int numInt = 10;
    double numDouble = numInt; // 10.0

    //Explicit type casting
    double pi = 3.14;
    int numPi = (int) pi;



    public static void main(String[] args) {

        //type casting between different data types
        int myInt = 4;
        char myChar = (char) (myInt + 'A'); //70
        System.out.println(myChar);
    }

}
