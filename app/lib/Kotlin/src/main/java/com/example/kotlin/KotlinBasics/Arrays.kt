package com.example.kotlin.KotlinBasics

fun main(){
    val osNames = arrayOf("Windows", "Android", "MacOs", "Linux")
    
    val firstOsName = osNames[0]
    println(firstOsName)
    
    // Modifying elements
    osNames[1] = "iOS"
    println(osNames[1])
    
    val size = osNames.size
    println(size)
    
    for (name in osNames){
        println(name)
    }
    
    osNames.forEach { name -> println(name) }
}