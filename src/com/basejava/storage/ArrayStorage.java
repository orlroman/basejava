package com.basejava.storage;

import com.basejava.model.Resume;

public class ArrayStorage extends AbstractArrayStorage {

    protected void insertResume(Resume resume, int index) {
        storage[size] = resume;
    }

    @Override
    protected void fillDeletedResume(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
