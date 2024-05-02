package com.basejava.storage;

import com.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public int storageSize() {
        return size;
    }

    @Override
    public void clearStorage() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public Resume[] getAllResumes() {
        return Arrays.copyOf(storage, size);
    }

    @Override
    public void updateResume(Resume resume, int index) {
        storage[index] = resume;
    }

    @Override
    public void saveResume(Resume resume, int index) {
        insertResume(resume, index);
        size++;
    }

    @Override
    public void deleteResume(int index) {
        fillDeletedResume(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public Resume getResume(int index) {
        return storage[index];
    }

    abstract void insertResume(Resume resume, int index);

    abstract void fillDeletedResume(int index);

}
