package com.Lithy.kidstalking.model;

public class screen_arabiccolor {

    int img_image;
    int img_color;
    int audio;


    public screen_arabiccolor(int img_image, int img_color,int audio) {
        this.img_image = img_image;
        this.img_color = img_color;
        this.audio=audio;
    }

    public int getImg_image() {
        return img_image;
    }

    public void setImg_image(int img_image) {
        this.img_image = img_image;
    }

    public int getImg_color() {
        return img_color;
    }

    public void setImg_color(int img_color) {
        this.img_color = img_color;
    }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }
}
