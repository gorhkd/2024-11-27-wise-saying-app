package com.ll.domain.repository;

import com.ll.domain.entity.WiseSaying;

import java.util.List;
import java.util.Optional;

public abstract class WiseSayingMemoryRepository {
    abstract void add(WiseSaying wiseSaying);

    abstract List<WiseSaying> findAll();

    abstract boolean removeById(int deleteId);

    abstract Optional<WiseSaying> findById(int modifyId);

    abstract void modify(WiseSaying wiseSaying);
}
