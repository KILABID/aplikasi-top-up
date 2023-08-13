package com.latihanpbo.topupgenius.Mobile;

public class ModelMobile {
    String tvGame;
    int imageGame;
    public ModelMobile(String tvGame, int imageDrawable){
        this.tvGame = tvGame;
        this.imageGame = imageDrawable;
    }
    public String getTvGame(){
        return tvGame;
    }
    public void setTvTitle(String tvGame){
        this.tvGame = tvGame;
    }
    public int getImageGame(){
        return imageGame;
    }
    public void setImageDrawable(int imageGame){
        this.imageGame = imageGame;
    }
}
