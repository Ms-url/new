package com.example.text;

public class Data {
    private String name;
    private int imageId;
    public Data(String name,int imageId) {
        this.imageId=imageId;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
