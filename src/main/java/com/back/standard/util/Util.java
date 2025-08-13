package com.back.standard.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Util {
    // 이너 클래스. static을 사용하는 이유는 Util에서 바로 접근해서 사용할 수 있도록 하기 위해서이다.
    public static class file{  // 소문자 사용 이유 : 실제 Java 클래스와 중복되어 불편함


        public static void touch(String filePath) {
            Path path = Paths.get(filePath);
            String content = "Hello, Java NIO!";

            try {
                Files.write(path, content.getBytes(),
                        StandardOpenOption.CREATE, // 없으면 생성
                        StandardOpenOption.TRUNCATE_EXISTING); // 기존 내용 덮어쓰기
                System.out.println("파일 생성 및 쓰기 완료");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static boolean exists(String filePath) {
            return Files.exists(Paths.get(filePath));
        }
    }

    public static class json{

    }
}
