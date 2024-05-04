package com.basejava.storage;

import com.basejava.model.Resume;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapStorage extends AbstractStorage {

    private final Map<Object, Resume> storage = new HashMap();

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
        return storage.values().toArray(new Resume[0]);
    }

    @Override
    protected void updateResume(Object searchKey, Resume resume) {
        storage.put(searchKey, resume);
    }

    @Override
    protected void saveResume(Object searchKey, Resume resume) {
        storage.put(searchKey, resume);
    }

    @Override
    protected void deleteResume(Object searchKey) {
        storage.remove(searchKey);
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return storage.get(searchKey);
    }

    @Override
    protected int findIndex(String uuid) {

        for (Map.Entry<Object, Resume> entry : storage.entrySet()) {
            if (Objects.equals(entry.getValue().getUuid(), uuid)) {
                // Если значения равны, возвращаем ключ
                return (Integer) entry.getKey();
            }
        }
        return -1;

        //    for (int i = 0; i <= storage.size(); i++) {
        //    if (storage.get(i).getUuid().equals(uuid)) {
        //        return i;
        //    }
      //  }
       // return -1;
    }
}
