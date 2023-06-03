package com.example.kenneth_dela_cruz_android_developer;

public class made_for_you_class {
    int image;
    String title;
    String message;
    public made_for_you_class(){

    }
    public made_for_you_class(int image, String title, String message) {
        this.image = image;
        this.title = title;
        this.message = message;
    }

    public int getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getMessage() {
        return message;
    }
}
