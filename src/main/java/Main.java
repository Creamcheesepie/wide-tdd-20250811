import java.io.BufferedInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        experiment1();
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
}
