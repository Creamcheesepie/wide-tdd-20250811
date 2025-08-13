package com.back.domain.wiseSaying.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PageDto {
    private int page;
    private int pageSize;
    private int totalItems;
    private List<WiseSaying> content;

    public int getTotalPages(){
        return (totalItems % pageSize) == 0 ? totalItems / pageSize : (totalItems / pageSize) + 1;
    }
}
