package com.back;

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
        return wiseSayingList;
    }
}
