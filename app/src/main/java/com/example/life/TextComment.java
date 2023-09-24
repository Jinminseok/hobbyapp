package com.example.life;

import com.google.firebase.Timestamp;
public class TextComment extends Comment {
    private String text;

    public TextComment(String text, Timestamp timestamp) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

