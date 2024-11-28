package com.ll.domain.repository;

import com.ll.domain.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class WiseSayingRepository {

    private final List<WiseSaying> wiseSayings;
    private int lastId;

    public WiseSayingRepository() {
        this.wiseSayings = new ArrayList<>();
        this.lastId = 0;
    }

    public void add(WiseSaying wiseSaying) {
        wiseSaying.setId(++lastId);
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

    public void modify(WiseSaying wiseSaying) {
        // 현재는 메모리에 저장되기 때문에 여기서 딱히 할일이 없다.
    }
}
