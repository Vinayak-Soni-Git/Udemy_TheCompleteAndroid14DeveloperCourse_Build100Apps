package com.example.udemy_thecompleteandroid14developercourse_build100apps.ArchitecturePatterns.MVPPattern;

public class Presenter {
    AppView appView;
    
    public Presenter(AppView appView){
        this.appView = appView;
    }
    
    // 2- Linkage between presenter and model
    public MVPModel getAppFromModel(){
        return new MVPModel("Master Coding App", 900000, 4);
    }
    
    // 3-Linkage between presenter and MainActivity (calling the interface)
    public void getAppDetails(){
        appView.onGetAppName(getAppFromModel().getAppName() );
    }
    
    
}
