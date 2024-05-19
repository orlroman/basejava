package com.basejava.storage;

import com.basejava.model.Resume;

import java.util.List;

public interface Storage {

    int size();

    void clear();

    List<Resume> getAllSorted();

    void update(Resume resume);

    void save(Resume resume);

    void delete(String uuid);

    Resume get(String uuid);
}
