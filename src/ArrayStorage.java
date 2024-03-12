import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    void clear() {
        Arrays.fill(storage, 0, storage.length - 1, null);
    }

    void save(Resume r) {
        if (size() < storage.length) {
            storage[size()] = r;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].toString().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < size(); i++) {
            if (storage[i].toString().equals(uuid)) {
                if (size() > 1 && i < size() - 1) {
                    System.arraycopy(storage, i + 1, storage, i, (size() - 1) - i);
                }
                storage[size() - 1] = null;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, size());
    }

    int size() {
        int countResumes = 0;
        for (Resume resume : storage) {
            if (resume == null) {
                break;
            }
            countResumes++;
        }
        return countResumes;
    }
}
