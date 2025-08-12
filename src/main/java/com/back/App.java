package com.back;

import java.util.Scanner;

public class App {
    private Scanner sc;
    public App(Scanner sc) {
        this.sc = sc;
    }

    public void run() {
        WiseSayingController wc = new WiseSayingController(sc);
        wc.controller();
    }
}
