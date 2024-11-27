package com.ll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if (cmd.equals("종료")) {
                System.out.println("명언앱을 종료합니다.");
                break;
            } else if (cmd.equals("등록")) {
                WiseSaying.actionAdd(scanner);
            } else if (cmd.equals("목록")) {
                WiseSaying.actionList();
            } else if (cmd.equals("삭제")) {
                WiseSaying.actionDelete(scanner);
            } else if (cmd.equals("수정")) {
                WiseSaying.actionModify(scanner);
            }
        }

    }
}

       class WiseSaying {
           int id;
           String content;
           String author;
           static int lastId = 1;
           static List<WiseSaying> wiseSayings = new ArrayList<>();

           public WiseSaying(int id, String content, String author) {
               this.id = id;
               this.content = content;
               this.author = author;
           }

           @Override
           public String toString() {
               return id + " // " + author + " // " + content;
           }


           public static void actionAdd(Scanner scanner) {
               System.out.print("명언) ");
               String content = scanner.nextLine().trim();
               System.out.print("작가) ");
               String author = scanner.nextLine().trim();
               WiseSaying wiseSaying = new WiseSaying(lastId, content, author);
               wiseSayings.add(wiseSaying);
               System.out.println(lastId + "번 명언이 생성되었습니다.");
               lastId++;
           }


           public static void actionList() {
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


           public static void actionDelete(Scanner scanner) {
               System.out.println("삭제 할 명언 번호를 입력해주세요.");
               int deleteId = scanner.nextInt();
               scanner.nextLine();
               boolean found = wiseSayings.removeIf(e -> e.id == deleteId);
               if (found) {
                   System.out.println(deleteId + "번 명언이 삭제되었습니다.");
               } else {
                   System.out.println(deleteId + "번 명언이 존재하지않습니다.");
               }
           }


           public static void actionModify(Scanner scanner) {
               boolean found = false;
               System.out.println("수정 할 명언 번호를 입력해주세요.");
               int modifyId = scanner.nextInt();
               scanner.nextLine();

               for (WiseSaying wiseSaying : wiseSayings) {
                   if (wiseSaying.id == modifyId) {
                       System.out.println("기존 명언) " + wiseSaying.content);
                       String newContent = scanner.nextLine().trim();
                       System.out.println("기존 작가) " + wiseSaying.author);
                       String newAuthor = scanner.nextLine().trim();
                       wiseSaying.content = newContent;
                       wiseSaying.author = newAuthor;
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
