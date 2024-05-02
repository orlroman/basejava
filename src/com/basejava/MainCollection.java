package com.basejava;

import com.basejava.model.Resume;

import java.util.*;

public class MainCollection {
    private static final String UUID_1 = "uuid1";
    private static final Resume RESUME_1 = new Resume(UUID_1);

    private static final String UUID_2 = "uuid2";
    private static final Resume RESUME_2 = new Resume(UUID_2);

    private static final String UUID_3 = "uuid3";
    private static final Resume RESUME_3 = new Resume(UUID_3);

    private static final String UUID_4 = "uuid4";
    private static final Resume RESUME_4 = new Resume(UUID_4);

    public static void main(String[] args) {
        Collection<Resume> collection = new ArrayList<>();

        collection.add(RESUME_1);
        collection.add(RESUME_2);
        collection.add(RESUME_3);
        System.out.println(collection);
        System.out.println(collection.size());
        System.out.println(collection.contains(RESUME_1));

        // Maybe replaced for
        // collection.removeIf(r -> r.equals(RESUME_1));
        Iterator<Resume> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Resume r = iterator.next();
            if (r.equals(RESUME_1)) {
                iterator.remove();
            }
        }

        System.out.println(collection);

    }
}
