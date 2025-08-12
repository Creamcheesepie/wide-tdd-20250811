package com.back;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    @DisplayName("=== 명언 앱 === 출력")
    void t1(){
        String outputStr = AppTestRunner.appRun("종료");

        assertThat(outputStr).isEqualTo("=== 명언 앱 ===");
    }

    @Test
    @DisplayName("등록 기능 테스트")
    void t2(){
        String out = AppTestRunner.appRun("""
                등록
                현재를 사랑하라.
                작자미상
                종료
                """);

        assertThat(out).contains("명령) ");
        assertThat(out).contains("명언 : ");
        assertThat(out).contains("작가 : ");
    }

    @Test
    @DisplayName("목록기능 테스트")
    void t3(){

    }

}
