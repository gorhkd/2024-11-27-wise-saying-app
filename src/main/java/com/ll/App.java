package com.ll;

import com.ll.domain.controller.WiseSayingController;

import java.util.Scanner;

public class App {
    WiseSayingController wiseSayingController;
    public App() {
        this.wiseSayingController = new WiseSayingController();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        wiseSayingController.makeSampleData();
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")) {
                System.out.println("명언앱을 종료합니다.");
                break;
            } else if (cmd.equals("등록")) {
                wiseSayingController.actionAdd();
            } else if (cmd.equals("목록")) {
                wiseSayingController.actionList();
            } else if (cmd.equals("삭제")) {
                wiseSayingController.actionDelete();
            } else if (cmd.equals("수정")) {
                wiseSayingController.actionModify();
            }
        }
    }
}