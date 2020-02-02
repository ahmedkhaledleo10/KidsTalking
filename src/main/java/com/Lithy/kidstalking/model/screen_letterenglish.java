package com.Lithy.kidstalking.model;

public class screen_letterenglish {

    int img_animal;
    int img_letter;
    int audio;
    String letter;

    public screen_letterenglish(int img_animal, int img_letter,int audio ,String letter) {
        this.img_animal = img_animal;
        this.img_letter = img_letter;
        this.audio=audio;
        this.letter = letter;
    }

    public int getImg_animal() {
        return img_animal;
    }

    public void setImg_animal(int img_animal) {
        this.img_animal = img_animal;
    }

    public int getImg_letter() {
        return img_letter;
    }

    public void setImg_letter(int img_letter) {
        this.img_letter = img_letter;
    }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }
}
