package com.basejava.storage;

import com.basejava.exception.StorageException;
import com.basejava.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {

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
    public void updateResume(Integer searchKey, Resume resume) {
        storage[searchKey] = resume;
    }

    @Override
    public void saveResume(Integer searchKey, Resume resume) {
        if (size() == STORAGE_LIMIT) {
            throw new StorageException("OVERFLOW!", resume.getUuid());
        } else {
            insertResume(resume, searchKey);
            size++;
        }
    }

    @Override
    public void deleteResume(Integer searchKey) {
        fillDeletedResume(searchKey);
        storage[size - 1] = null;
        size--;
    }

    @Override
    public Resume getResume(Integer searchKey) {
        return storage[searchKey];
    }

    @Override
    protected boolean isExist(Integer searchKey) {
        return searchKey >= 0;
    }

    abstract void insertResume(Resume resume, int index);

    abstract void fillDeletedResume(int index);
}
