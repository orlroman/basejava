package com.basejava.storage;

import com.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage<String> {

    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected boolean isExist(String searchKey) {
        return storage.containsKey(searchKey);
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public List<Resume> getAllResumes() {
        return new ArrayList<>(storage.values());
    }

    @Override
    protected void updateResume(String searchKey, Resume resume) {
        storage.put(searchKey, resume);
    }

    @Override
    protected void saveResume(String searchKey, Resume resume) {
        storage.put(searchKey, resume);
    }

    @Override
    protected void deleteResume(String searchKey) {
        storage.remove(searchKey);
    }

    @Override
    protected Resume getResume(String searchKey) {
        return storage.get(searchKey);
    }

    @Override
    protected String findSearchKey(String uuid) {
        return uuid;
    }
}
