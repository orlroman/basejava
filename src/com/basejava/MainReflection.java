package com.basejava;

import com.basejava.model.Resume;

import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) {
        Resume resume = new Resume();

        try {
            Method resumeMethod = resume.getClass().getDeclaredMethod("toString");
            System.out.println(resumeMethod.invoke(resume));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
