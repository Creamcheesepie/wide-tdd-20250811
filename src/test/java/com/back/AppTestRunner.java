package com.back;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {
    //원본 어플리케이션 실행시 필요한 반복 작업을 전담하는 클래스
    public static String appRun(String input){
        Scanner sc = TestUtil.genScanner(input);
        ByteArrayOutputStream outputStream = TestUtil.setOutToByteArray();
        new App(sc).run();

        return outputStream.toString();
    }
}
