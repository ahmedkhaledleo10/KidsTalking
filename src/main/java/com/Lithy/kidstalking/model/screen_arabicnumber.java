package com.Lithy.kidstalking.model;

public class screen_arabicnumber {

    int img_count;
    int img_number;
    int audio;
    String number;




    public screen_arabicnumber(int img_count, int img_number,int audio,String number) {
        this.img_count = img_count;
        this.img_number = img_number;
        this.audio=audio;
        this.number = number;
    }

    public int getImg_count() {
        return img_count;
    }

    public void setImg_count(int img_count) {
        this.img_count = img_count;
    }

    public int getImg_number() {
        return img_number;
    }

    public void setImg_number(int img_number) {
        this.img_number = img_number;
    }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }


}
