package com.back;

public class WiseSaying {
    private int number;
    private String content;
    private String author;

    public WiseSaying(int number, String content, String author) {
        this.number = number;
        this.content = content;
        this.author = author;
    }

    public int getNumber() {
        return number;
    }

    public String getContent() {
        return content;
    }

    public String getAuthor() {
        return author;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return number +"    /   " + content + "    /   " + author;
    }
}
