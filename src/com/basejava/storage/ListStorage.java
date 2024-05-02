package com.basejava.storage;

import com.basejava.model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {

    private final List<Resume> storageList = new ArrayList<>();

    @Override
    public int storageSize() {
        return storageList.size();
    }

    @Override
    public void clearStorage() {
        storageList.clear();
    }

    @Override
    public Resume[] getAllResumes() {
        Resume[] resumes = new Resume[storageList.size()];
        return storageList.toArray(resumes);
    }

    @Override
    public void updateResume(Resume resume, int index) {
        storageList.add(index, resume);
    }

    @Override
    public void saveResume(Resume resume, int index) {
        storageList.add(resume);
    }

    @Override
    public void deleteResume(int index) {
        storageList.remove(index);
    }

    @Override
    public Resume getResume(int index) {
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
