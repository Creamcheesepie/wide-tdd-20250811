package com.back;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WiseSayingRepositoryTest {
    private WiseSayingRepository wiseSayingRepository = new WiseSayingRepository();

    @Test
    @DisplayName("get Last Number test")
    void t1(){
        int lastNumber = wiseSayingRepository.getLastWiseSayingNumber();
        assertThat(lastNumber).isEqualTo(0);
    }

    @Test
    @DisplayName("명언 저장소에 1개의 명언을 추가하고 리스트에 있는지 확인")
    void t2(){
        WiseSaying wiseSaying = new WiseSaying(1,"test1","test2");
        wiseSayingRepository.addWiseSaying(wiseSaying);
        List<WiseSaying> wiseSayingList =  wiseSayingRepository.getWiseSayingList();

        assertThat(wiseSayingList.getLast()).isEqualTo(wiseSaying);
    }




}
