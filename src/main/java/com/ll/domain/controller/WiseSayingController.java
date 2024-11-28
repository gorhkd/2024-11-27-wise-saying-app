package com.ll.domain.controller;

import com.ll.domain.entity.WiseSaying;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class WiseSayingController {
         List<WiseSaying> wiseSayings = new ArrayList<>();
         int lastId = 0;


        public void makeSampleData() {
            add("나의 죽음을 적들에게 알리지 말라.", "이순신 장군");
            add("삶이 있는 한 희망은 있다.", "키케로");
        }


        public void add(String content, String author){
            lastId++;
            WiseSaying wiseSaying = new WiseSaying(lastId, content, author);
            wiseSayings.add(wiseSaying);
        }

        public void actionAdd(Scanner scanner) {
            System.out.print("명언) ");
            String content = scanner.nextLine().trim();
            System.out.print("작가) ");
            String author = scanner.nextLine().trim();
            add(content, author);
            System.out.println(lastId + "번 명언이 생성되었습니다.");
        }


        public void actionList() {
            if (wiseSayings.isEmpty()) {
                System.out.println("목록이 비어있습니다.");
            } else {
                List<WiseSaying> copyWiseSaying = new ArrayList<>(wiseSayings);
                Collections.reverse(copyWiseSaying);
                System.out.println("명언번호 // 작가 // 명언");
                for (WiseSaying wiseSaying : copyWiseSaying) {
                    System.out.println(wiseSaying);
                }
            }
        }


        public void actionDelete(Scanner scanner) {
            System.out.println("삭제 할 명언 번호를 입력해주세요.");
            int deleteId = scanner.nextInt();
            scanner.nextLine();
            boolean found = wiseSayings.removeIf(e -> e.getId() == deleteId);
            if (found) {
                System.out.println(deleteId + "번 명언이 삭제되었습니다.");
            } else {
                System.out.println(deleteId + "번 명언이 존재하지않습니다.");
            }
        }


        public void actionModify(Scanner scanner) {
            boolean found = false;
            System.out.println("수정 할 명언 번호를 입력해주세요.");
            int modifyId = scanner.nextInt();
            scanner.nextLine();

            for (WiseSaying wiseSaying : wiseSayings) {
                if (wiseSaying.getId() == modifyId) {
                    System.out.println("기존 명언) " + wiseSaying.getContent());
                    String newContent = scanner.nextLine().trim();
                    System.out.println("기존 작가) " + wiseSaying.getAuthor());
                    String newAuthor = scanner.nextLine().trim();
                    wiseSaying.setContent(newContent);
                    wiseSaying.setAuthor(newAuthor);
                    found = true;
                }
            }
            if (found) {
                System.out.println("수정이 완료되었습니다.");
            } else {
                System.out.println(modifyId + "번 명언이 존재하지 않습니다.");
            }
        }
    }

