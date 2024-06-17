package com.example.kotlin.LambdaExpressions

fun main(){
    val numbers = listOf(1, 2, 3, 4, 5)
    
    val squareAnonymousFunction = fun (x:Int):Int{ return x*x }
    
    val squareNumbers = numbers.map(squareAnonymousFunction)
    
    println(squareNumbers)
}