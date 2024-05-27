package com.basejava;

import com.basejava.model.SectionType;

public class TestSingleton {
    private static TestSingleton instance;
    public static TestSingleton getInstance() {
        if (instance == null) {
            instance = new TestSingleton();
        }
        return instance;
    }

    private TestSingleton() {

    }

    public static void main(String[] args) {
        TestSingleton.getInstance().toString();
        Singletone instance = Singletone.valueOf("INSTANCE");
        System.out.println(instance.ordinal());
        for(SectionType type : SectionType.values()) {
            System.out.println(type.getTitle());
        }
    }

    public enum Singletone {
        INSTANCE
    }

}
