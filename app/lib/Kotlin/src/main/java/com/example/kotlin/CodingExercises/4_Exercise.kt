package com.example.kotlin.CodingExercises

import java.util.Scanner

fun main(){
    
    val scanner = Scanner(System.`in`)
    val text = scanner.nextLine()
    count(text)
}

fun count(text:String){
    var ch = text.toCharArray()
    var letters = 0
    var spaces = 0
    var numbers = 0
    var other = 0
    
    for (c in ch.withIndex()){
        if (Character.isLetter(c.value)){
            letters++
        } else if(Character.isDigit(c.value)){
            numbers++
        } else if (Character.isSpaceChar(c.value)){
            spaces++
        } else {
            other++
        }
    }
    
    println("$letters letters, $spaces spaces, $numbers numbers, $other other characters")
}