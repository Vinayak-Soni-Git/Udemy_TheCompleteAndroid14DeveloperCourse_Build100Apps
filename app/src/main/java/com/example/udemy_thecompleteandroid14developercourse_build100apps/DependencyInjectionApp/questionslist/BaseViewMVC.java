package com.example.udemy_thecompleteandroid14developercourse_build100apps.DependencyInjectionApp.questionslist;


import android.content.Context;
import android.view.View;

import androidx.annotation.IdRes;
import androidx.annotation.StringRes;

public abstract class BaseViewMVC<ListenerType> extends BaseObservable<ListenerType> implements ObservableViewMVC<ListenerType> {
    private View rootView;

    @SuppressWarnings("Unchecked")
    protected <T extends View> T findViewById(@IdRes int id){
        return (T) rootView.findViewById(id);
    }
    
    protected Context getContext(){
        return getRootView().getContext();
    }
    
    protected String getString(@StringRes int id){
        return getContext().getString(id);
    }
    
    protected String getString(@StringRes int id, Object... formatArgs){
        return getContext().getString(id, formatArgs);
    }
    
    
    @Override
    public View getRootView() {
        return rootView;
    }
    
    protected void setRootView(View rootView){
        this.rootView = rootView;
    }
}
