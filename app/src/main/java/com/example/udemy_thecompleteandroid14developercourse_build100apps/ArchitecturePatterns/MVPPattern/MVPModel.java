package com.example.udemy_thecompleteandroid14developercourse_build100apps.ArchitecturePatterns.MVPPattern;

public class MVPModel {

    String appName;
    int appDownloads;
    int appRating;

    public MVPModel(String appName, int appDownloads, int appRating){
        this.appName = appName;
        this.appDownloads = appDownloads;
        this.appRating = appRating;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public int getAppDownloads() {
        return appDownloads;
    }

    public void setAppDownloads(int appDownloads) {
        this.appDownloads = appDownloads;
    }

    public int getAppRating() {
        return appRating;
    }

    public void setAppRating(int appRating) {
        this.appRating = appRating;
    }
}
