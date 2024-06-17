package com.example.kotlin.LambdaExpressions

fun main(){
    // With parameters and return type
    val add:(Int, Int) -> Int = {a:Int, b:Int -> a+b}
    val result = add(5, 3)
    println(result)
    
    // With parameters and no return type
    val add2:(Int, Int) -> Unit = {a, b -> println(a+b)}
    add2(5, 3)
    
    // No parameters and but with return type
    val add3:() -> String = {"Welcome to our course"}
    println(add3.invoke())
    
    // No parameters and no return type
    val add4:() -> Unit = { println("No Parameters, no return type") }
    
    // Direct use of lambda expressions
    println({a:Int, b:Int -> a*b} (4, 5))
    
}