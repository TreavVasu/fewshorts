package com.learning.fewshorts;

import com.learning.fewshorts.RecievedData.Article;

import java.util.List;

public class SingleObject {

        //create an object of SingleObject
        private static SingleObject instance = new SingleObject();

        private String author;
        private String title;
        private String description;
        private String urlToImage;
        private String publishedAt;
        private String content;


    //make the constructor private so that this class cannot be
        //instantiated
        private SingleObject(){}

        //Get the only object available
        public static SingleObject getInstance(){
            return instance;
        }

        // here u can declare getter setter


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


    }
