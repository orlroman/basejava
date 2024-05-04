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
    public void updateResume(Object searchKey, Resume resume) {
        int index = (Integer) searchKey;
        storage[index] = resume;
    }

    @Override
    public void saveResume(Object searchKey, Resume resume) {
        int index = (Integer) searchKey;
        insertResume(resume, index);
        size++;
    }

    @Override
    public void deleteResume(Object searchKey) {
        int index = (Integer) searchKey;
        fillDeletedResume(index);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public Resume getResume(Object searchKey) {
        int index = (Integer) searchKey;
        return storage[index];
    }

    abstract void insertResume(Resume resume, int index);

    abstract void fillDeletedResume(int index);
}
