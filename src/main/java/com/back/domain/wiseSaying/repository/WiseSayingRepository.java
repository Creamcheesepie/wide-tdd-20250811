package com.back.domain.wiseSaying.repository;

import com.back.domain.wiseSaying.entity.PageDto;
import com.back.domain.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    List<WiseSaying> wiseSayingList = new ArrayList<>();

    public int getLastWiseSayingNumber() {
        if(wiseSayingList.size() == 0) return 0;
        else return wiseSayingList.getLast().getNumber();
    }

    public void addWiseSaying(WiseSaying wiseSaying) {
        wiseSayingList.add(wiseSaying);
    }

    public List<WiseSaying> getWiseSayingList(){
        return wiseSayingList.reversed();
    }

    public PageDto getWiseSayingListWithPage(int page, int pageSize){
        List<WiseSaying> content =  wiseSayingList.reversed().stream()
                .skip((page - 1 ) * pageSize)
                .limit(pageSize)
                .toList();

        return new PageDto(page,pageSize,wiseSayingList.size(),content);
    }

    public boolean deleteWiseSayingNumber(int number) {
        int targetIndex = getWiseSayingIndexByNumber(number);
        if(targetIndex == -1) return false;
        else wiseSayingList.remove(targetIndex);
        return true;
    }

    public int getWiseSayingIndexByNumber(int number){
        for(int i = 0; i<wiseSayingList.size(); i++){
            int searchingNumber = wiseSayingList.get(i).getNumber();
            if(searchingNumber == number) return i;
        }
        return -1;
    }


    public void setWiseSaying(int index, WiseSaying wiseSaying) {
        wiseSayingList.set(index, wiseSaying);
    }

    public WiseSaying getWiseSayingByNumber(int number) {
        for(WiseSaying ws : wiseSayingList){
            if(ws.getNumber() == number) return ws;
        }

        return null;
    }

    public List<WiseSaying> findByContentContainingOrAuthorContainingDesc(String kw) {
        return wiseSayingList.stream()
                .filter(w -> w.getAuthor().contains(kw) || w.getContent().contains(kw))
                .toList()
                .reversed();
    }

    public List<WiseSaying> findByContentContainingDesc(String kw) {
        return wiseSayingList.stream()
                .filter(w -> w.getContent().contains(kw))
                .toList()
                .reversed();
    }

    public List<WiseSaying> findByAuthorContainingDesc(String kw) {
        return wiseSayingList.stream()
                .filter(w -> w.getAuthor().contains(kw))
                .toList()
                .reversed();
    }
}
