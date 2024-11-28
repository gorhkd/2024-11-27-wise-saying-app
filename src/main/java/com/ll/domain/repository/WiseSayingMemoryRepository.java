package com.ll.domain.repository;

import com.ll.domain.entity.WiseSaying;

import java.util.List;
import java.util.Optional;

public interface WiseSayingMemoryRepository {
    void add(WiseSaying wiseSaying);

    List<WiseSaying> findAll();

    boolean removeById(int deleteId);

    Optional<WiseSaying> findById(int modifyId);

    void modify(WiseSaying wiseSaying);
}
