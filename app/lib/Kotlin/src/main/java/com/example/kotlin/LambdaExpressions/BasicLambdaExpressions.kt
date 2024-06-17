package com.example.kotlin.LambdaExpressions

fun main(){
    val add:(Int, Int) -> Int = {a, b -> a+b}
    val result = add(5, 3)
    println(result)
}