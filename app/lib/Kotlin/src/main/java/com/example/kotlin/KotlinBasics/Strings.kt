package com.example.kotlin.KotlinBasics

fun main(){
    val text:String = "Hello World"
    val text2:String = "Bye World"
    
    val text3 = "$text $text2"
    
    println(text3)
    
    //String interpolation
    val x = 5
    val y = 3
    val result = "The sum of $x and $y is ${x+y}"
    println(result)
    
    val length:Int = text.length
    println(length)
    
    val subText = text.substring(0, 4)
    println(subText)
    
    val str1 = "Hello"
    val str2 = "Hi"
    
    val comparisonResult = str1+str2
    println(comparisonResult)
    
    
}