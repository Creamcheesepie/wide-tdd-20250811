package com.back.domain.wiseSaying.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WiseSaying {
    private int number;
    private String content;
    private String author;

    public WiseSaying(int number, String content, String author) {
        this.number = number;
        this.content = content;
        this.author = author;
    }


    @Override
    public String toString() {
        return number + "    /   " + content + "    /   " + author;
    }
}
