package com.example.kotlin.ObjectOrientedProgramming

fun main(){
    val ordinaryRobot:OrdinaryRobot = OrdinaryRobot("max")
    ordinaryRobot.walk()
    ordinaryRobot.turnLightOn()
    
    val superRobot = SuperRobot("buddy")
    superRobot.walk()
    superRobot.cleanHouse()
    
    val fireRobot = FireRobot("hero")
    fireRobot.speak("here is the saviour")
    fireRobot.fire()
}

open class GeneralRobot(private val name:String){
    fun walk(){
        println("The robot is walking now...")
    }
    fun speak(message:String){
        println("$name says $message")
    }
}

class OrdinaryRobot(name:String):GeneralRobot(name){
    fun turnLightOn(){
        println("The light is turned on")
    }
}

class SuperRobot(name:String):GeneralRobot(name){
    fun cleanHouse(){
        println("The house is clean now")
    }
}

class FireRobot(name:String):GeneralRobot(name){
    fun fire(){
        println("Firing")
    }
}