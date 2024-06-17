package com.example.kotlin.CodingExercises

import java.util.Scanner

fun main(){
    var a:Int
    var b:Int
    var temp:Int
    
    var scanner = Scanner(System.`in`)
    a = scanner.nextInt()
    b = scanner.nextInt()
    
    temp = a
    a = b
    b = temp
    
    println("$a, $b")
}