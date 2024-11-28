package com.ll.domain.controller;

import com.ll.domain.entity.WiseSaying;
import com.ll.domain.repository.WiseSayingRepository;
import com.ll.domain.service.WiseSayingService;

import java.util.*;

public class WiseSayingController {
           private final WiseSayingService wiseSayingService;
           private final WiseSayingRepository wiseSayingRepository;
           private final Scanner scanner;

        public WiseSayingController() {
           this.wiseSayingService = new WiseSayingService();
           this.wiseSayingRepository = new WiseSayingRepository();
           this.scanner = new Scanner(System.in);
    }

        public void makeSampleData() {
            wiseSayingService.add("나의 죽음을 적들에게 알리지 말라.", "이순신 장군");
            wiseSayingService.add("삶이 있는 한 희망은 있다.", "키케로");
        }

        public void actionAdd() {
            System.out.print("명언) ");
            String content = scanner.nextLine().trim();
            System.out.print("작가) ");
            String author = scanner.nextLine().trim();
            wiseSayingService.add(content, author);
            System.out.println("명언이 생성되었습니다.");
        }

        public void actionList() {
            List<WiseSaying> wiseSayings = wiseSayingService.findAll();
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


        public void actionDelete() {
            System.out.println("삭제 할 명언 번호를 입력해주세요.");
            int deleteId = scanner.nextInt();
            scanner.nextLine();
            boolean found = wiseSayingService.removeById(deleteId);
            if (found) {
                System.out.println(deleteId + "번 명언이 삭제되었습니다.");
            } else {
                System.out.println(deleteId + "번 명언이 존재하지않습니다.");
            }
        }


        public void actionModify() {
            System.out.println("수정 할 명언 번호를 입력해주세요.");
            int modifyId = scanner.nextInt();
            scanner.nextLine();
            Optional<WiseSaying> opWiseSaying = wiseSayingService.findById(modifyId);
            if (opWiseSaying.isEmpty()) {
                System.out.println(modifyId + "번 명언이 존재하지 않습니다.");
            } else {
                WiseSaying wiseSaying = opWiseSaying.get();
                System.out.println("기존 명언) " + wiseSaying.getContent());
                String newContent = scanner.nextLine().trim();
                System.out.println("기존 작가) " + wiseSaying.getAuthor());
                String newAuthor = scanner.nextLine().trim();
                wiseSayingService.modify(wiseSaying, newContent, newAuthor);
                System.out.println("수정이 완료되었습니다.");
            }
        }
    }

