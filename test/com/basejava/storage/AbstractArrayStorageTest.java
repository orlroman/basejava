package com.basejava.storage;

import com.basejava.exception.ExistStorageException;
import com.basejava.exception.NotExistStorageException;
import com.basejava.exception.StorageException;
import com.basejava.model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractArrayStorageTest {
    private final Storage storage;
    private static final Resume RESUME_1 = new Resume("uuid1");
    private static final Resume RESUME_2 = new Resume("uuid2");
    private static final Resume RESUME_3 = new Resume("uuid3");

    public AbstractArrayStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void size() throws Exception {
        assertEquals(3, storage.size());
    }

    @Test
    public void clear() throws Exception {
        storage.clear();
        assertEquals(0, storage.size());
    }

    @Test
    public void getAll() throws Exception {
        Resume[] all = storage.getAll();
        assertEquals(3, all.length);
        assertEquals(RESUME_1, all[0]);
        assertEquals(RESUME_2, all[1]);
        assertEquals(RESUME_3, all[2]);
    }

    @Test
    public void update() throws Exception {
        storage.update(RESUME_1);
        assertSame(RESUME_1, storage.get(RESUME_1.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        storage.get("NotExist");
    }

    @Test
    public void save() throws Exception {
        Resume[] all = storage.getAll();
        assertEquals(3, storage.size());
        assertEquals(RESUME_1, all[0]);
        assertEquals(RESUME_2, all[1]);
        assertEquals(RESUME_3, all[2]);
    }

    @Test(expected = StorageException.class)
    public void saveOverflow() throws Exception {
        try {
            for (int i = 4; i <= AbstractArrayStorage.STORAGE_LIMIT ; i++) {
                storage.save(new Resume());
            }
        } catch (StorageException e) {
            fail("Early overflow!");
        }
        storage.save(new Resume());
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        storage.save(RESUME_1);
    }

    @Test
    public void delete() throws Exception {
        storage.delete(RESUME_1.getUuid());
        assertEquals(2, storage.size());

        Resume[] resumes = storage.getAll();
        for (Resume resume : resumes) {
            assertNotSame(RESUME_1, storage.get(resume.getUuid()));
        }
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        storage.delete("Delete");
    }

    @Test
    public void get() throws Exception {
        assertSame(RESUME_1, storage.get(RESUME_1.getUuid()));
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        storage.get("dummy");
    }
}