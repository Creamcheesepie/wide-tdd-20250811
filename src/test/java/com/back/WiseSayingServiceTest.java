package com.back;

import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.domain.wiseSaying.service.WiseSayingService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WiseSayingServiceTest {
    WiseSayingService wiseSayingService = new WiseSayingService();

    @Test
    @DisplayName("명언 서비스에 명언 추가 클래스 동작 확인")
    void t1() {
        wiseSayingService.addWiseSaying("test1", "test2");
    }

    @Test
    @DisplayName("명언 목록 확인")
    void t2() {
        t1();

        List<WiseSaying> list = wiseSayingService.getWiseSayingList();
        WiseSaying target = new WiseSaying(1, "test1", "test2");
        WiseSaying listElement = list.getLast();

        assertThat(target.getNumber()).isEqualTo(listElement.getNumber());
        assertThat(target.getContent()).isEqualTo(listElement.getContent());
        assertThat(target.getAuthor()).isEqualTo(listElement.getAuthor());

    }

    @Test
    @DisplayName("명언 삭제 확인")
    void t3() {
        t1();

        List<WiseSaying> list = wiseSayingService.getWiseSayingList();
        boolean isDelete = wiseSayingService.deleteWiseSayingByNumber(1);

        assertThat(isDelete).isEqualTo(true);
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("없는 명언 삭제 시도 확인")
    void t3_2() {

        List<WiseSaying> list = wiseSayingService.getWiseSayingList();
        boolean isDelete = wiseSayingService.deleteWiseSayingByNumber(1);

        assertThat(isDelete).isEqualTo(false);
        assertThat(list.size()).isEqualTo(0);
    }

    @Test
    @DisplayName("명언 수정 확인")
    void t4() {
        t1();

        List<WiseSaying> list = wiseSayingService.getWiseSayingList();
        wiseSayingService.setChangeWiseSaying(1, "newContent1", "newAuthor1");

        assertThat(list.getFirst().getContent()).isEqualTo("newContent1");
        assertThat(list.getFirst().getAuthor()).isEqualTo("newAuthor1");

    }

}
