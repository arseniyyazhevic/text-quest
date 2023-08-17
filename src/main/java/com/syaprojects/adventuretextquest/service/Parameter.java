package com.syaprojects.adventuretextquest.service;

public class Parameter {
    private String text;
    private String pathImg;

    public Parameter(String text, String pathImg) {
        this.text = text;
        this.pathImg = pathImg;
    }

    public Parameter(){

    }

    public String getText() {
        return text;
    }

    public String getPathImg() {
        return pathImg;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setPathImg(String pathImg) {
        this.pathImg = pathImg;
    }
}
