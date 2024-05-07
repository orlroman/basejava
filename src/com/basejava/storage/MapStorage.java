package com.basejava.storage;

import com.basejava.model.Resume;

import java.util.*;

public class MapStorage extends AbstractStorage {

    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected boolean isExist(Object searchKey) {
        for (Map.Entry<String, Resume> entry : storage.entrySet()) {
            if (Objects.equals(entry.getValue().getUuid(), findSearchKey((String)searchKey))) {
                return true;
            }
        }
        return false;
    }

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
//        return storage.values().toArray(new Resume[0]);

        // Преобразование значений Map в список и сортировка по значениям Resume
        List<Map.Entry<String, Resume>> sortedEntries = new ArrayList<>(storage.entrySet());
        sortedEntries.sort(Map.Entry.comparingByKey());

        // Преобразование отсортированного списка в массив
        return sortedEntries.stream()
                .map(Map.Entry::getValue)
                .toArray(Resume[]::new);
    }

    @Override
    protected void updateResume(Object searchKey, Resume resume) {
        storage.put((String) searchKey, resume);
    }

    @Override
    protected void saveResume(Object searchKey, Resume resume) {
        storage.put((String) searchKey, resume);
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
    protected Object findSearchKey(String uuid) {
        return uuid;
    }
}
