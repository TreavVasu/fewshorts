package com.learning.fewshorts;

import com.learning.fewshorts.RecievedData.Article;

import java.util.List;

public class SingleObject {

        //create an object of SingleObject
        private static SingleObject instance = new SingleObject();
        private List<String> writer;
        private int posi;
        private int number;

        private List<String> title;
        private List<String> description;
        private List<String> urlToImage;
        private List<String> publishedAt;

    public List<String> getTitle() {
        return title;
    }

    public void setTitle(List<String> title) {
        this.title = title;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public List<String> getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(List<String> urlToImage) {
        this.urlToImage = urlToImage;
    }

    public List<String> getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(List<String> publishedAt) {
        this.publishedAt = publishedAt;
    }

    public List<String> getContent() {
        return content;
    }

    public void setContent(List<String> content) {
        this.content = content;
    }

    private List<String> content;


    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPosi() {
        return posi;
    }

    public void setPosi(int posi) {
        this.posi = posi;
    }

    public List<String> getWriter() {
        return writer;
    }

    public void setWriter(List<String> writer) {
        this.writer = writer;
    }


    //make the constructor private so that this class cannot be
        //instantiated
        private SingleObject(){}

        //Get the only object available
        public static SingleObject getInstance(){
            return instance;
        }

        // here u can declare getter setter



    }
