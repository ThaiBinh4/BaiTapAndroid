package com.example.democontentprovider.model;

import androidx.appcompat.app.AppCompatActivity;

import java.io.Serializable;

public class Message  implements Serializable {
    private String name;
    private String content;
    private String date;

    public Message(String name,String date, String Content) {
        this.name = name;
        this.date=date;
        content = Content;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String toString() {
        return "Từ :"+ name+"\nThời gian: "+date+"\nNội dung: "+ content;
    }
}
