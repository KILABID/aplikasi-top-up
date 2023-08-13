package com.latihanpbo.topupgenius.Home;

public class ModelMain {
    String tvTitle;
    int imageDrawable;
    public ModelMain(String tvTitle, int imageDrawable){
        this.tvTitle = tvTitle;
        this.imageDrawable = imageDrawable;
    }
    public String getTvTitle(){
        return tvTitle;
    }
    public void setTvTitle(String tvTitle){
        this.tvTitle = tvTitle;
    }
    public int getImageDrawable(){
        return imageDrawable;
    }
    public void setImageDrawable(int imageDrawable){
        this.imageDrawable = imageDrawable;
    }
}
