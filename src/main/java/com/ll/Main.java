package com.ll;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<WiseSaying> wiseSayings = new ArrayList<>();
        int lastId = 1;

        System.out.println("== 명언 앱 ==");
        while (true){
            System.out.print("명령) ");
            String cmd = scanner.nextLine().trim();

            if(cmd.equals("종료")){
                System.out.println("명언앱을 종료합니다.");
                break;
            }

            else if(cmd.equals("등록")){
                System.out.print("명언) ");
                String content = scanner.nextLine().trim();
                System.out.print("작가) ");
                String author = scanner.nextLine().trim();
                WiseSaying wiseSaying = new WiseSaying(lastId, content, author);
                wiseSayings.add(wiseSaying);
                System.out.println(lastId + "번 명언이 생성되었습니다.");
                lastId++;
            }

            else if(cmd.equals("목록")){
                if(wiseSayings.isEmpty()){
                    System.out.println("목록이 비어있습니다.");
                } else{
                    List<WiseSaying> copyWiseSaying;
                    copyWiseSaying = wiseSayings;
                    Collections.reverse(copyWiseSaying);
                    System.out.println("명언번호 // 작가 // 명언");
                for(WiseSaying wiseSaying : copyWiseSaying){
                    System.out.println(wiseSaying);
                }
            }
          }


        }

    }

   public static class WiseSaying {
       int id;
       String content;
       String author;


   public WiseSaying(int id, String content, String author) {
           this.id = id;
           this.content = content;
           this.author = author;
       }

       @Override
       public String toString() {
           return id + "       " + author + "    " + content;
       }

   }
}