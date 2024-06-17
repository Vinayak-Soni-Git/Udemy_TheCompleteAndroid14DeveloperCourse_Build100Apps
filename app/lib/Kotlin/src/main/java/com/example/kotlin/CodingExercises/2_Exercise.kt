package com.example.kotlin.CodingExercises

import java.util.Scanner

fun main(){
    var scanner = Scanner(System.`in`)
    
    var radius = scanner.nextInt()
    
    var perimeter:Double = 2*3.1415*radius
    var area = radius*radius*3.1414
    
    println("$perimeter, $area")
}