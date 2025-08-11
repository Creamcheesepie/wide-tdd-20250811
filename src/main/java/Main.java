import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Optional;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
//        experiment1();
        experiment2();
    }

    public static void experiment1(){
        String input = """
                등록
                너 자신을 알라
                소크라테스
                """; // """내용"""은 텍스트 블록을 표현한다.

        Scanner sc = new Scanner(input);

        String cmd = sc.nextLine(); // 입력을 대기받는다.
        String content = sc.nextLine();

        System.out.println("cmd = " + cmd);
        System.out.println("content = " + content);
    }

    public static void experiment2(){
        System.out.println("안녕하세요");
//        System.out은 일종의 통로 -> 모니터로 출력이 된다.

//        출력을 저장소로 돌린다면?
        PrintStream originalOut = System.out; // 백업본

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream(); // 저장소
        PrintStream printStream = new PrintStream(outputStream); // 일종의 출력기
        System.setOut(printStream); // 방향을 바꿈

        System.out.print("하하하");

        String outStr = outputStream.toString();

        System.setOut(originalOut);
        System.out.println("outStr = " + outStr);

    }
}
