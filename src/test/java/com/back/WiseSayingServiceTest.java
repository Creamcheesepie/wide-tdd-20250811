package com.back;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class WiseSayingServiceTest {
    WiseSayingService wiseSayingService = new WiseSayingService();

    @Test
    @DisplayName("명언 서비스에 명언 추가 클래스 동작 확인")
    void t1(){
        wiseSayingService.addWiseSaying("test1", "test2");
    }

    @Test
    @DisplayName("명언 목록 확인")
    void t2(){
        t1();

        List<WiseSaying> list =  wiseSayingService.getWiseSayingList();
        WiseSaying target = new WiseSaying(1,"test1","test2");
        WiseSaying listElement = list.getLast();

        assertThat(target.getNumber()).isEqualTo(listElement.getNumber());
        assertThat(target.getContent()).isEqualTo(listElement.getContent());
        assertThat(target.getAuthor()).isEqualTo(listElement.getAuthor());

    }


}
