package com.back.domain.wiseSaying.controller;

import com.back.domain.wiseSaying.entity.PageDto;
import com.back.domain.wiseSaying.service.WiseSayingService;
import com.back.domain.wiseSaying.entity.WiseSaying;
import com.back.util.CommandSplitter;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WiseSayingController {
    private WiseSayingService wiseSayingService = new WiseSayingService();
    private Scanner sc;
    private String cmd;
    private int number;

    public WiseSayingController(Scanner sc) {
        this.sc = sc;
    }

    public void controller() {
        System.out.println("=== 명언 앱 ===");
        boolean isRun = true;
        while (isRun) {
            System.out.print("명령) ");
            CommandSplitter commandSplitter =new CommandSplitter();
            commandSplitter.setCommand(sc.nextLine());
            cmd = commandSplitter.getActionName();
            number = commandSplitter.getParamAsInt("", -1);

            switch (cmd) {
                case "등록" -> {
                    System.out.print("명언 : ");
                    String content = sc.nextLine();
                    System.out.print("작가 : ");
                    String author = sc.nextLine();
                    wiseSayingService.addWiseSaying(content, author);
                }
                case "목록" -> {
                    int page = commandSplitter.getParamAsInt("page", 1);
                    int pageSize = commandSplitter.getParamAsInt("pageSize", 5);
                    PageDto pageDto = wiseSayingService.getWiseSayingListWithPage(page, pageSize);

                    String pageMenu = IntStream.rangeClosed(1, pageDto.getTotalPages())
                                    .mapToObj((int i) -> i == pageDto.getPage() ? "[%d]".formatted(i) : String.valueOf(i))
                                            .collect(Collectors.joining(" / "));

                    System.out.println(pageMenu);
                    System.out.println("번호  /   내용  /   작가  ");

                    for (WiseSaying wiseSaying : pageDto.getContent()) {
                        System.out.println(wiseSaying);
                    }
                }
                case "삭제" ->{
                    boolean isDelete = wiseSayingService.deleteWiseSayingByNumber(number);
                    if(isDelete) System.out.println(number + "번 명언이 삭제되었습니다.");
                    else System.out.println(number + "번 명언이 없습니다.");
                }
                case "수정" ->{
                    WiseSaying wiseSaying = wiseSayingService.getWiseSayingByNumber(number);
                    if(wiseSaying == null) System.out.println(number + "번 명언이 없습니다.");
                    else {
                        System.out.println("기존 명언 : " + wiseSaying.getContent());
                        String newContent = sc.nextLine();
                        System.out.println("기존 작가 : " + wiseSaying.getAuthor());
                        String newAuthor = sc.nextLine();

                        wiseSayingService.setChangeWiseSaying(number,newContent,newAuthor);
                    }
                }case "검색" ->{
                    String kw = commandSplitter.getParam("keyword" ,"");
                    String kwType = commandSplitter.getParam("keywordType", "");
                    int pageNumber = commandSplitter.getParamAsInt("page",0);

                    List<WiseSaying> wiseSayings = wiseSayingService.findListDesc(kw, kwType);

                    wiseSayings
                            .reversed()
                            .stream()
                            .forEach(wiseSaying -> System.out.printf("%d / %s / %s%n",
                                    wiseSaying.getNumber(), wiseSaying.getAuthor(), wiseSaying.getContent()));

                }
                case "종료" -> {
                    System.out.println("프로그램을 종료합니다.");
                    isRun = false;
                }

            }
        }
    }

}
