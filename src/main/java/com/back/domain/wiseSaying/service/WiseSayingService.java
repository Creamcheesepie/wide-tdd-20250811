package com.back.domain.wiseSaying.service;

import com.back.domain.wiseSaying.entity.PageDto;
import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.repository.WiseSayingRepository;

import java.util.List;

public class WiseSayingService {
    private WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();
    private WiseSaying wiseSaying;

    public void addWiseSaying(String content, String author) {
        int number = wiseSayingRepository.getLastWiseSayingNumber();
        number += 1;
        wiseSaying = new WiseSaying(number,content,author);
        wiseSayingRepository.addWiseSaying(wiseSaying);
    }

    public List<WiseSaying> getWiseSayingList(){
        return wiseSayingRepository.getWiseSayingList();
    }

    public PageDto getWiseSayingListWithPage(int page, int pageSize){
        return wiseSayingRepository.getWiseSayingListWithPage(page, pageSize);
    }


    public boolean deleteWiseSayingByNumber(int i) {
        return wiseSayingRepository.deleteWiseSayingNumber(i);
    }

    public boolean setChangeWiseSaying(int number, String newContent, String newAuthor) {
        int index = wiseSayingRepository.getWiseSayingIndexByNumber(number);
        if(index == -1 ) return false;

        wiseSaying = new WiseSaying(number,newContent,newAuthor);
        wiseSayingRepository.setWiseSaying(index, wiseSaying);
        return true;
    }

    public int findWiseSayingIndex(int number){
        int index = wiseSayingRepository.getWiseSayingIndexByNumber(number);
        return index;
    }

    public WiseSaying getWiseSayingByNumber(int number){
        return wiseSayingRepository.getWiseSayingByNumber(number);
    }

    public List<WiseSaying> findListDesc(String kw, String kwType) {
        return switch (kwType){
            case "content" -> wiseSayingRepository.findByContentContainingDesc(kw);
            case "author" -> wiseSayingRepository.findByAuthorContainingDesc(kw);
            default -> wiseSayingRepository.findByContentContainingOrAuthorContainingDesc(kw);
        };
    }
}
