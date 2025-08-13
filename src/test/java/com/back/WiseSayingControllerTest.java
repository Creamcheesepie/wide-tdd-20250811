package com.back;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class WiseSayingControllerTest {
    @Test
    @DisplayName("=== 명언 앱 === 출력")
    void t1(){
        String outputStr = AppTestRunner.appRun("""
                종료
                """);

        assertThat(outputStr).isEqualTo("=== 명언 앱 ===");
    }
}
