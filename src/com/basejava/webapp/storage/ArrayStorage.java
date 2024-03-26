package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final int STORAGE_LIMIT = 10000;
    private final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (isExist(index)) {
            storage[index] = resume;
            System.out.println(resume.getUuid() + " is updated");
        } else {
            System.out.println(resume.getUuid() + " not found");
        }
    }

    public void save(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (size >= storage.length) {
            System.out.println("OVERFLOW!");
        } else if (isExist(index)) {
            System.out.println(resume.getUuid() + " already exists");
        } else {
            storage[size++] = resume;
        }
    }

    public Resume get(String uuid) {
        int index = findIndex(uuid);
        if (isExist(index)) {
            return storage[index];
        }
        System.out.println(uuid + " not found");
        return null;
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (isExist(index)) {
            storage[index] = storage[size - 1];
            storage[--size] = null;
        } else {
            System.out.println(uuid + " not found");
        }
    }

    private int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    private boolean isExist(int index) {
        return index >= 0;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }
}
