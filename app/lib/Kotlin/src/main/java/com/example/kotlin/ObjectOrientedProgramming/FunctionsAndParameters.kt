package com.example.kotlin.ObjectOrientedProgramming

fun main(){
    // Functions: are blocks of code that encapsulate a specific task or functionality
    
    // Function Declaration
//    fun functionName(parameter1: Type, parameter2: Type):ReturnType{
//        Function body
    //    Perform some operation
    //    Optionally return a value
//    }
    sayHello("Jack")
    sumTwoNumbers(10, 30);
    
}
fun sayHello(name:String){
    println("Hello $name")
}

fun sumTwoNumbers(x:Int, y:Int):Int{
    return x+y;
}