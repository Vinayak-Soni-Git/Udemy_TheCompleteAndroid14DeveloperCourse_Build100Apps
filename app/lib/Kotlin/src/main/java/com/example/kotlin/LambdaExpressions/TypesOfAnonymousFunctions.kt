package com.example.kotlin.LambdaExpressions

fun main(){
    // With parameters and return value
    val multiply = fun(a:Int, b:Int):Int{return a*b}
    println(multiply.invoke(6, 4))
    
    // With parameters and no return value
    val multiply2 = fun(a:Int, b:Int){ println(""+a*b) }
    multiply2(4, 5)
    
    // No parameters and return value
    val message = fun():String{return "Welcome"}
    println(message())
    
    // No parameters and no return value
    val message2 = fun():Unit { println("Welcome") }
    message2()
}