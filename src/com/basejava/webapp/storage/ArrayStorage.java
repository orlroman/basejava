package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;
import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int size = 0;
    private int index;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void update(Resume resume) {
        if (isResume(resume.getUuid())) {
            storage[index] = resume;
            System.out.println(resume.getUuid() + " is updated");
        } else {
            System.out.println(resume.getUuid() + " not found");
        }
    }

    public void save(Resume resume) {
        if (!isResume(resume.getUuid()) && size < storage.length) {
            storage[size++] = resume;
        } else {
            System.out.println(resume.getUuid() + " already exists");
        }
    }

    public Resume get(String uuid) {
        if (isResume(uuid)) {
            return storage[index];
        }
        System.out.println(uuid + " not found");
        return null;
    }

    public void delete(String uuid) {
        if (isResume(uuid)) {
            if (size > 1 && index < size - 1) {
                System.arraycopy(storage, index + 1, storage, index, (size - 1) - index);
            }
            storage[--size] = null;
        } else {
            System.out.println(uuid + " not found");
        }
    }

    private boolean isResume(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                index = i;
                return true;
            }
        }
        return false;
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
