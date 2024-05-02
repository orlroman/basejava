package com.basejava.storage;

import com.basejava.exception.ExistStorageException;
import com.basejava.exception.NotExistStorageException;
import com.basejava.model.Resume;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListStorageTest {

    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME_1 = new Resume(UUID_1);

    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME_2 = new Resume(UUID_2);

    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME_3 = new Resume(UUID_3);

    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_4 = new Resume(UUID_4);

    private final Storage listStorage = new ListStorage();

    @Before
    public void setUp() throws Exception {
        listStorage.clear();
        listStorage.save(RESUME_1);
        listStorage.save(RESUME_2);
        listStorage.save(RESUME_3);
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void clear() {
        listStorage.clear();
        assertSize(0);
    }

    @Test
    public void getAll() {
        Resume[] expected = {RESUME_1, RESUME_2, RESUME_3};
        assertArrayEquals(expected, listStorage.getAll());
    }

    @Test
    public void update() throws Exception {
        Resume updatedResume = new Resume(UUID_1);
        listStorage.update(updatedResume);
        assertEquals(updatedResume, listStorage.get(UUID_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void updateNotExist() throws Exception {
        listStorage.get(UUID_4);
    }

    @Test
    public void save() throws Exception {
        listStorage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test(expected = ExistStorageException.class)
    public void saveExist() throws Exception {
        listStorage.save(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() throws Exception {
        listStorage.delete(UUID_1);
        assertSize(2);
        assertGet(RESUME_1);
    }

    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() throws Exception {
        listStorage.delete(UUID_4);
    }

    @Test
    public void get() throws Exception {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExist() throws Exception {
        listStorage.get(UUID_4);
    }

    private void assertSize(int size) {
        assertEquals(size, listStorage.size());
    }

    private void assertGet(Resume resume) {
        assertSame(resume, listStorage.get(resume.getUuid()));
    }
}