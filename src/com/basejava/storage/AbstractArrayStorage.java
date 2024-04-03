package com.basejava.storage;

import com.basejava.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {

    protected static final int STORAGE_LIMIT = 10000;
    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage,0, size, null);
        size = 0;
    }

    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    private boolean isExist(int index) {
        return index >= 0;
    }

    public final void update(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (!isExist(index)) {
            System.out.println(resume.getUuid() + " not found");
        } else {
            storage[index] = resume;
            System.out.println(resume.getUuid() + " is updated");
        }
    }

    public final void save(Resume resume) {
        int index = findIndex(resume.getUuid());
        if (size == STORAGE_LIMIT) {
            System.out.println("OVERFLOW!");
        } else if (isExist(index)) {
            System.out.println(resume.getUuid() + " already exists");
        } else {
            insertResume(resume, index);
            size++;
        }
    }

    public final void delete(String uuid) {
        int index = findIndex(uuid);
        if (!isExist(index)) {
            System.out.println(uuid + " not found");
        } else {
            fillDeleteResume(index);
            storage[size - 1] = null;
            size--;
        }
    }

    public final Resume get(String uuid) {
        int index = findIndex(uuid);
        if (!isExist(index)) {
            System.out.println(uuid + " not found");
            System.out.println("findIndex = " + index);
            return null;
        }
        return storage[index];
    }

    abstract void insertResume(Resume resume, int index);
    abstract void fillDeleteResume(int index);
    abstract int findIndex(String uuid);

}
