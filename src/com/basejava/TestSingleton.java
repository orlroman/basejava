package com.basejava;

import com.basejava.model.SectionType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        List<SectionType> list = new ArrayList<>();
        for(SectionType type : SectionType.values()) {
            list.add(type);
        }

        System.out.println(list);
        Map<SectionType, String> map = new HashMap<>();
        for(SectionType type : SectionType.values()) {
            map.put(type, type.getTitle());
        }
        System.out.println(map);
    }

    public enum Singletone {
        INSTANCE
    }

}


