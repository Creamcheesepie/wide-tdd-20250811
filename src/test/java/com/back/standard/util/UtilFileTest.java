package com.back.standard.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilFileTest {
    @Test
    @DisplayName("파일 생성")
    void t1(){
        // 무언가를 세팅하고
        String filePath = "test.txt";

        // 수행하면
        Util.file.touch(filePath);

        // 결과가 나온다.
        boolean rst = Util.file.exists(filePath);

        assertThat(rst).isEqualTo(true);

        //테스트가 끝나면 테스트 파일을 삭제한다.
    }

    @Test
    @DisplayName("파일 삭제")
    void t2(){
        // given
        String filePath = "test.txt";
        Util.file.touch(filePath);

        // when
        Util.file.delete(filePath);


        // then
        boolean rst = Util.file.exists(filePath);
        assertThat(rst).isFalse();
    }
}
