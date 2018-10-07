package com.example.application;

public class Word {
    private String name;
    private  String age;
    private int Image=notIamge;
    private static final int notIamge=-1;
    private int audio;
    public Word(String name, String age, int audio) {
        this.name = name;
        this.age = age;
        this.audio=audio;
    }

    public Word(String name, String age, int image, int audio) {
        this.name = name;
        this.age = age;
        this.Image = image;
        this.audio=audio;
    }

    public Word() {
    }

    public int getImage() {
        return Image;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public boolean gethashimage() {
        return Image!=notIamge;
    }

    public int getAudio() {
        return audio;
    }
}
