package com.example.kotlin.ObjectOrientedProgramming

fun main(){
    
}


class SecondaryConstructor(name:String){
    var name:String = ""
    var modelYear:Int = 0
    init {
        println("Init block")
    }
    
    constructor(name:String, model:String) : this(name)
    
    constructor(name:String, modelYear:Int): this(name){
        this.name = name
        this.modelYear = modelYear
    }
}