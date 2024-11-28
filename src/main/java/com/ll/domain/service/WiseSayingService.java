package com.ll.domain.service;

import com.ll.domain.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WiseSayingService {

    private final List<WiseSaying> wiseSayings;
    private int lastId;

    public WiseSayingService() {
        this.wiseSayings = new ArrayList<>();
        this.lastId = 0;
    }

    public int getLastId(){
        return lastId;
    }

    public void add(String content, String author){
        lastId++;
        WiseSaying wiseSaying = new WiseSaying(lastId, content, author);
        wiseSayings.add(wiseSaying);
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public boolean removeById(int deleteId) {
       return wiseSayings.removeIf(e -> e.getId() == deleteId);
    }

    public Optional<WiseSaying> findById(int modifyId) {
        return wiseSayings.stream().filter(e -> e.getId() == modifyId)
                .findFirst();
    }

    public void modify(WiseSaying wiseSaying, String newContent, String newAuthor) {
        wiseSaying.setContent(newContent);
        wiseSaying.setAuthor(newAuthor);
    }
}
