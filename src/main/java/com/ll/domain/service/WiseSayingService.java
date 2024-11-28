package com.ll.domain.service;

import com.ll.domain.entity.WiseSaying;
import com.ll.domain.repository.WiseSayingRepository;

import java.util.List;
import java.util.Optional;

public class WiseSayingService {
    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService() {
        this.wiseSayingRepository = new WiseSayingRepository();
    }

    public void add(String content, String author){
        WiseSaying wiseSaying = new WiseSaying(0, content, author);
        wiseSayingRepository.add(wiseSaying);
    }

    public List<WiseSaying> findAll() {
        return wiseSayingRepository.findAll();
    }

    public boolean removeById(int deleteId) {
       return wiseSayingRepository.removeById(deleteId);
    }

    public Optional<WiseSaying> findById(int modifyId) {
        return wiseSayingRepository.findById(modifyId);
    }

    public void modify(WiseSaying wiseSaying, String newContent, String newAuthor) {
        wiseSaying.setContent(newContent);
        wiseSaying.setAuthor(newAuthor);

        wiseSayingRepository.modify(wiseSaying);
    }
}
