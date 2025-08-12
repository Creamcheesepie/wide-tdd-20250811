package com.back;

import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
    private WiseSayingService wiseSayingService = new WiseSayingService();
    private Scanner sc;
    private String cmd;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
    }

    public void controller(){
        System.out.print("=== 명언 앱 ===");
        while(true){
            System.out.print("명령) ");
            cmd = sc.nextLine();

            switch (cmd){
                case "등록" -> {
                    System.out.print("명언 : ");
                    String content = sc.nextLine();
                    System.out.print("작가 : ");
                    String author = sc.nextLine();
                    wiseSayingService.addWiseSaying(content, author);
                }
                case "목록" -> {
                    System.out.println("번호  /   내용  /   작가  ");
                    List<WiseSaying> wiseSayingList = wiseSayingService.getWiseSayingList();
                    for(WiseSaying wiseSaying : wiseSayingList){
                        System.out.println(wiseSaying);
                    }
                }
                case "종료" -> {
                    System.out.println("프로그램을 종료합니다.");
                }
            }
        }
    }

}
