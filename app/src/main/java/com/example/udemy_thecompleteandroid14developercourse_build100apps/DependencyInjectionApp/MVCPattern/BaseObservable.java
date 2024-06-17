package com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.MVCPattern;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class BaseObservable<ListenerClass> {
    private Set<ListenerClass> listenerClasses = Collections.newSetFromMap(
            new ConcurrentHashMap<ListenerClass, Boolean>(1)
    );
    
    public final void registerListener(ListenerClass listener){
        listenerClasses.add(listener);  
    }
    
    public final void unRegisterListener(ListenerClass listener){
        listenerClasses.remove(listener);
    }
    
    protected final Set<ListenerClass> getListeners(){
        return Collections.unmodifiableSet(listenerClasses);
    }
}