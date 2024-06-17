package com.example.kotlin.ObjectOrientedProgramming

fun main(){
    val robot:Robot = Robot("Buddy")
    robot.walk()
    robot.speak("Hello my friends")
}

class Robot(val name:String){
    fun walk(){
        println("The robot is walking now...")
    }
    fun speak(message:String){
        println("$name says $message")
    }
}