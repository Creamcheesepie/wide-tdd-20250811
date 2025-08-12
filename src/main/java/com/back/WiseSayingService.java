package com.back;

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

}
