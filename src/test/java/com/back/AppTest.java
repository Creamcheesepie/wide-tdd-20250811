package com.back;

import com.back.util.CommandSplitter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    @DisplayName("=== 명언 앱 === 출력")
    void t1(){
        String outputStr = AppTestRunner.appRun("종료");
        assertThat(outputStr).isEqualTo("""
                === 명언 앱 ===
                명령) 프로그램을 종료합니다.
                """);
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

    @Test
    @DisplayName("삭제기능 테스트")
    void t4(){
        String out = AppTestRunner.appRun("""
                등록
                현재를 사랑하라.
                작자미상
                삭제?=1
                종료
                """);

        assertThat(out).contains("1번 명언이 삭제되었습니다.");
    }

    @Test
    @DisplayName("삭제기능 테스트")
    void t4_1(){
        String out = AppTestRunner.appRun("""
                등록
                현재를 사랑하라.
                작자미상
                삭제?=2
                종료
                """);

        assertThat(out).contains("2번 명언이 없습니다.");
    }

    @Test
    @DisplayName("수정기능 테스트")
    void t5(){
        String out = AppTestRunner.appRun("""
                등록
                현재를 사랑하라.
                작자미상
                수정?=1
                과거에 연연하지 마라
                작자미상
                목록
                종료
                """);
        assertThat(out).contains("현재를 사랑하라");
        assertThat(out).contains("작자미상");
        assertThat(out).contains("과거에 연연하지 마라");
        assertThat(out).contains("작자미상");
    }

    @Test
    @DisplayName("커맨드 분류기 테스트")
    void t_Split(){
        CommandSplitter commandSplitter = new CommandSplitter();
        commandSplitter.setCommand("검색?keywordType=content&keyword=과거");
        String keywordType = commandSplitter.getParam("keywordType","none");

        assertThat(keywordType).isEqualTo("content");
    }

    @Test
    @DisplayName("페이징 테스트")
    void t6(){
        String input = IntStream.rangeClosed(1,10)
                .mapToObj((int num) ->
                    """
                    등록
                    명언 %d
                    작가 %d
                    """.formatted(num,num)
                ).collect(Collectors.joining("\n"));

        input += "목록\n종료\n";

        String out = AppTestRunner.appRun(input);
        assertThat(out).contains("작가 10")
                .contains("작가 6")
                .doesNotContain("작가 5");
    }

    @Test
    @DisplayName("페이징 테스트 3페이지")
    void t6_1(){
        String input = IntStream.rangeClosed(1,11)
                .mapToObj((int num) ->
                        """
                        등록
                        명언 %d
                        작가 %d
                        """.formatted(num,num)
                ).collect(Collectors.joining("\n"));

        input += "목록?page=3\n" +
                "종료\n";

        String out = AppTestRunner.appRun(input);
        assertThat(out)
                .contains("작가 1")
                .contains("1 / 2 / [3]")
                .doesNotContain("작가 6");
    }

    @Test
    @DisplayName("페이지 목록 이쁘게 출력")
    void t7(){
        String input = IntStream.rangeClosed(1,10)
                .mapToObj((int num) ->
                        """
                        등록
                        명언 %d
                        작가 %d
                        """.formatted(num,num)
                ).collect(Collectors.joining("\n"));

        input += "목록?page=1\n" +
                "종료\n";

        String out = AppTestRunner.appRun(input);
        assertThat(out)
                .contains("[1] / 2")
                .contains("10    /   명언 10    /   작가 10")
                .contains("9    /   명언 9    /   작가 9")
                .contains("8    /   명언 8    /   작가 8")
                .contains("7    /   명언 7    /   작가 7")
                .contains("6    /   명언 6    /   작가 6")
                .doesNotContain("5    /   명언 5    /   작가 5");
    }

    @Test
    @DisplayName("페이지 목록 이쁘게 출력 2페이지")
    void t7_1(){
        String input = IntStream.rangeClosed(1,10)
                .mapToObj((int num) ->
                        """
                        등록
                        명언 %d
                        작가 %d
                        """.formatted(num,num)
                ).collect(Collectors.joining("\n"));

        input += "목록?page=2\n" +
                "종료\n";

        String out = AppTestRunner.appRun(input);
        assertThat(out)
                .contains("1 / [2]")
                .contains("5    /   명언 5    /   작가 5")
                .contains("4    /   명언 4    /   작가 4")
                .contains("3    /   명언 3    /   작가 3")
                .contains("2    /   명언 2    /   작가 2")
                .contains("1    /   명언 1    /   작가 1")
                .doesNotContain("6    /   명언 6    /   작가 6");
    }



}
