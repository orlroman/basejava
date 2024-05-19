package com.basejava.storage;

import com.basejava.exception.StorageException;
import com.basejava.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage {

    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    @Override
    public List<Resume> getAllResumes() {
        return Arrays.asList(Arrays.copyOf(storage, size));
    }

    @Override
    public void updateResume(Object searchKey, Resume resume) {
        int index = (Integer) searchKey;
        storage[index] = resume;
    }

    @Override
    public void saveResume(Object searchKey, Resume resume) {
        if (size() == STORAGE_LIMIT) {
            throw new StorageException("OVERFLOW!", resume.getUuid());
        } else {
            int index = (Integer) searchKey;
            insertResume(resume, index);
            size++;
        }
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

    @Override
    protected boolean isExist(Object searchKey) {
        return (Integer) searchKey >= 0;
    }

    abstract void insertResume(Resume resume, int index);

    abstract void fillDeletedResume(int index);
}
