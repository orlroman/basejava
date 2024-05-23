package com.basejava.storage;

import com.basejava.exception.StorageException;
import com.basejava.model.Resume;
import org.junit.Test;

import static org.junit.Assert.fail;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest {

    protected AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() {
        storage.clear();
        try {
            for (int i = 0; i < AbstractArrayStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("Roman" + i));
            }
        } catch (StorageException e) {
            fail("Early overflow");
        }
        storage.save(new Resume("Overflow"));
    }
}
