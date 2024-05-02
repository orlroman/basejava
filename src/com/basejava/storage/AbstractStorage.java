package com.basejava.storage;

public abstract class AbstractStorage implements Storage {

    protected boolean isExist(int index) {
        return index >= 0;
    }
    abstract int findIndex(String uuid);
}
