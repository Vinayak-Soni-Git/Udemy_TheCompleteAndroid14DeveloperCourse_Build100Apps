package com.example.udemy_thecompleteandroid14developercourse_build100apps.dagger2.Dagger;

public class Coffee {
    String coffeeCup;
    
    public String getCoffeeCup(){
        River river = new River();
        Farm farm = new Farm();
        
        coffeeCup = farm.getCoffeeBeans()+river.getWater();
        return coffeeCup;
    }
}
