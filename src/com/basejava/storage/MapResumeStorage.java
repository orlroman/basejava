package com.basejava.storage;

import com.basejava.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {
    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected boolean isExist(Resume resume) {
        return resume != null;
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
    protected void updateResume(Resume searchKey, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void saveResume(Resume searchKey, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void deleteResume(Resume resume) {
        storage.remove((resume).getUuid());
    }

    @Override
    protected Resume getResume(Resume resume) {
        return resume;
    }

    @Override
    protected Resume findSearchKey(String uuid) {
        return storage.get(uuid);
    }
}
