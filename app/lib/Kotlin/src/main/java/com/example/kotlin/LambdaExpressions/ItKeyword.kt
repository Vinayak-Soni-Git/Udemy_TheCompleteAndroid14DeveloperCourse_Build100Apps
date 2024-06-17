package com.example.kotlin.LambdaExpressions

fun main(){
    val numbers = listOf(1, 2, 3, 4, 5)
    
    // Using lambda Expressions to square every number
    val squaredNumbers = numbers.map { x:Int -> x*x }
    println(squaredNumbers)
    
    //  Using an anonymous function to square every number
    val squareNumbersAnonymous = fun(x:Int):Int{
        return x*x
    }
    println(numbers.map(squareNumbersAnonymous))
    
    // Using it keyword
    val squareNumbers2 = numbers.map { it*it } 
    println(squareNumbers2)
    
    // Getting the even numbers from the list
    val evenNumbers = numbers.filter { x:Int -> x%2 ==0 }
    println(evenNumbers)
}