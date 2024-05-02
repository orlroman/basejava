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

    public void update(Resume resume) throws NotExistStorageException {
        int index = findIndex(resume.getUuid());
        if (!isExist(index)) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            updateResume(resume, index);
        }
    }

    @Override
    public void save(Resume resume) throws StorageException {
        int index = findIndex(resume.getUuid());
        if (isExist(index)) {
            throw new ExistStorageException(resume.getUuid());
        } else if (size() == STORAGE_LIMIT) {
            throw new StorageException("OVERFLOW!", resume.getUuid());
        } else {
            saveResume(resume, index);
        }
    }

    @Override
    public void delete(String uuid) throws NotExistStorageException {
        int index = findIndex(uuid);
        if (!isExist(index)) {
            throw new NotExistStorageException(uuid);
        } else {
            deleteResume(index);
        }
    }

    @Override
    public Resume get(String uuid) throws NotExistStorageException {
        int index = findIndex(uuid);
        if (!isExist(index)) {
            throw new NotExistStorageException(uuid);
        }
        return getResume(index);
    }

    abstract int findIndex(String uuid);

    abstract int storageSize();

    abstract void clearStorage();

    abstract Resume[] getAllResumes();

    abstract Resume getResume(int index);

    abstract void updateResume(Resume resume, int index);

    abstract void saveResume(Resume resume, int index);

    abstract void deleteResume(int index);
}
