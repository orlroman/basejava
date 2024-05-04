package com.basejava.storage;

import com.basejava.exception.ExistStorageException;
import com.basejava.exception.NotExistStorageException;
import com.basejava.exception.StorageException;
import com.basejava.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;

    public int size() {
        return storageSize();
    }

    public void clear() {
        clearStorage();
    }

    public Resume[] getAll() {
        return getAllResumes();
    }

    protected boolean isExist(int index) {
        return index >= 0;
    }

    public void update(Resume resume) {
        Object searchKey = getNotExistingSearchKey(resume.getUuid());
        updateResume(searchKey, resume);
    }

    @Override
    public void save(Resume resume) {
        Object searchKey = getExistingSearchKey(resume.getUuid());
        saveResume(searchKey, resume);
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = getNotExistingSearchKey(uuid);
        deleteResume(searchKey);
    }

    @Override
    public Resume get(String uuid) {
        Object searchKey = getNotExistingSearchKey(uuid);
        return getResume(searchKey);
    }

    private Object getNotExistingSearchKey(String uuid) {
        Object searchKey = findIndex(uuid);
        int index = (Integer) searchKey;
        if (!isExist(index)) {
            throw new NotExistStorageException(uuid);
        }
        return searchKey;
    }

    private Object getExistingSearchKey(String uuid) {
        Object searchKey = findIndex(uuid);
        int index = (Integer) searchKey;
        if (isExist(index)) {
            throw new ExistStorageException(uuid);
        } else if (size() == STORAGE_LIMIT) {
            throw new StorageException("OVERFLOW!", uuid);
        } else {
            return searchKey;
        }
    }

    abstract int findIndex(String uuid);

    abstract int storageSize();

    abstract void clearStorage();

    abstract Resume[] getAllResumes();

    abstract Resume getResume(Object searchKey);

    abstract void updateResume(Object searchKey, Resume resume);

    abstract void saveResume(Object searchKey, Resume resume);

    abstract void deleteResume(Object searchKey);
}
