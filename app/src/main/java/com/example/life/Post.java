package com.example.life;

public class Post {
    private String title;
    private String contents;

    public Post(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }
}
