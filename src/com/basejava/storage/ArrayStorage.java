package com.basejava.storage;

import com.basejava.model.Resume;

import java.util.Arrays;

public class ArrayStorage extends AbstractArrayStorage {

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (!isExist(index)) {
            System.out.println(resume.getUuid() + " not found");
        } else {
            storage[index] = resume;
            System.out.println(resume.getUuid() + " is updated");
        }
    }

    public void save(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (size == STORAGE_LIMIT) {
            System.out.println("OVERFLOW!");
        } else if (isExist(index)) {
            System.out.println(resume.getUuid() + " already exists");
        } else {
            storage[size] = resume;
            size++;
        }
    }

    public void delete(String uuid) {
        int index = findIndex(uuid);
        if (!isExist(index)) {
            System.out.println(uuid + " not found");
        } else {
            storage[index] = storage[size - 1];
            storage[size - 1] = null;
            size--;
        }
    }

    protected int findIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

}
