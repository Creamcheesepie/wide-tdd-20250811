package com.back;

import java.util.Scanner;

public class App {
    private Scanner sc;
    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        System.out.print("=== 명언 앱 ===");
        while(true){
            String cmd = sc.nextLine();
            if(cmd.equals("종료")) break;
        }
    }
}
