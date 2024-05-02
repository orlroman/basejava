package com.basejava.storage;

import com.basejava.exception.ExistStorageException;
import com.basejava.exception.NotExistStorageException;
import com.basejava.exception.StorageException;
import com.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage,0, size, null);
        size = 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    private boolean isExist(int index) {
        return index >= 0;
    }

    public void update(Resume resume) throws NotExistStorageException {
        int index = findIndex(resume.getUuid());
        if (!isExist(index)) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            storage[index] = resume;
            System.out.println(resume.getUuid() + " is updated");
        }
    }

    public void save(Resume resume) throws StorageException {
        int index = findIndex(resume.getUuid());
        if (isExist(index)) {
            throw new ExistStorageException(resume.getUuid());
        } else if (size == STORAGE_LIMIT) {
            throw new StorageException("OVERFLOW!", resume.getUuid());
        } else {
            insertResume(resume, index);
            size++;
        }
    }

    public void delete(String uuid) throws NotExistStorageException {
        int index = findIndex(uuid);
        if (!isExist(index)) {
            throw new NotExistStorageException(uuid);
        } else {
            fillDeletedResume(index);
            storage[size - 1] = null;
            size--;
        }
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (!isExist(index)) {
            throw new NotExistStorageException(uuid);
        }
        return storage[index];
    }

    abstract void insertResume(Resume resume, int index);
    abstract void fillDeletedResume(int index);
    abstract int findIndex(String uuid);

}
