package com.example.kotlin.LambdaExpressions

fun main(){
    
    fun operateOnNumbers(a:Int, b:Int, operation:(Int, Int)->Int):Int{
        return operation(a, b)
    }
    
    val addResult = operateOnNumbers(5, 3, {x, y -> x +y})
    val multiplyResult = operateOnNumbers(5, 3, {x, y -> x*y})
    
    println(addResult)
    println(multiplyResult)
    
    
}