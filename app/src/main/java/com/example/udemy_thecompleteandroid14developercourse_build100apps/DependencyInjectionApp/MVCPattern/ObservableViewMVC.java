package com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.MVCPattern;

public interface ObservableViewMVC<ListenerType> extends ViewMVC {
    void registerListener(ListenerType listenerType);
    void unRegisterListener(ListenerType listenerType);
    
    
}
