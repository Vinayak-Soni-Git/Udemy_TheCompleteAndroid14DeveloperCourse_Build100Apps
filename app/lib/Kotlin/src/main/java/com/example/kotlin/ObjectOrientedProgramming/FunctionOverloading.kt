package com.example.kotlin.ObjectOrientedProgramming

fun main(){
    println(sumTwoNumber(5, 5))
    println(sumTwoNumber(5.5f, 5.5f))
}

fun sumTwoNumber(x:Int, y:Int):Int{
    return x+y;
}

fun sumTwoNumber(x:Float, y:Float):Float{
    return x+y;
}