package com.basejava.storage;

import com.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private final List<Resume> storage = new ArrayList<>();

    @Override
    protected int storageSize() {
        return storage.size();
    }

    @Override
    protected void clearStorage() {
        storage.clear();
    }

    @Override
    protected Resume[] getAllResumes() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    protected void updateResume(Object searchKey, Resume resume) {
        int index = (Integer) searchKey;
        storage.set(index, resume);
    }

    @Override
    protected void saveResume(Object searchKey, Resume resume) {
        storage.add(resume);
    }

    @Override
    protected void deleteResume(Object searchKey) {
        int index = (Integer) searchKey;
        storage.remove(index);
    }

    @Override
    protected Resume getResume(Object searchKey) {
        int index = (Integer) searchKey;
        return storage.get(index);
    }

    @Override
    protected int findIndex(String uuid) {
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
