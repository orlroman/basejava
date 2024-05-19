package com.basejava.storage;

import com.basejava.exception.StorageException;
import com.basejava.model.Resume;
import org.junit.Test;

import static org.junit.Assert.fail;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    private final Storage storage;

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
        this.storage = storage;
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        storage.clear();
        try {
            for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("Roman"));
            }
        } catch (StorageException e) {
            fail("Early overflow");
        }
        storage.save(new Resume("Roman"));
    }
}
