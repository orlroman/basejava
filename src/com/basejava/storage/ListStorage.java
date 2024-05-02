package com.basejava.storage;

import com.basejava.exception.ExistStorageException;
import com.basejava.exception.NotExistStorageException;
import com.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private final List<Resume> storageList = new ArrayList<>();

    @Override
    public int size() {
        return storageList.size();
    }

    @Override
    public void clear() {
        storageList.clear();
    }

    @Override
    public Resume[] getAll() {
        Resume[] resumes = new Resume[storageList.size()];
        return storageList.toArray(resumes);
    }

    @Override
    public void update(Resume resume) throws NotExistStorageException {
        int index = findIndex(resume.getUuid());
        if (!isExist(index)) {
            throw new NotExistStorageException(resume.getUuid());
        } else {
            storageList.add(index, resume);
        }
    }

    @Override
    public void save(Resume resume) throws ExistStorageException {
        int index = findIndex(resume.getUuid());
        if (isExist(index)) {
            throw new ExistStorageException(resume.getUuid());
        } else {
            storageList.add(resume);
        }
    }

    @Override
    public void delete(String uuid) throws NotExistStorageException {
        int index = findIndex(uuid);
        if (!isExist(index)) {
            throw new NotExistStorageException(uuid);
        } else {
            storageList.remove(index);
        }
    }

    @Override
    public Resume get(String uuid) throws NotExistStorageException {
        int index = findIndex(uuid);
        if (!isExist(index)) {
            throw new NotExistStorageException(uuid);
        }
        return storageList.get(index);
    }

    @Override
    protected int findIndex(String uuid) {
        for (Resume resume : storageList) {
            if (resume.getUuid().equals(uuid)) {
                return storageList.indexOf(resume);
            }
        }
        return -1;
    }



}
