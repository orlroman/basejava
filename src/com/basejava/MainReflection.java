package com.basejava;

import com.basejava.model.Resume;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Resume resume = new Resume();

        Method resumeMethod = resume.getClass().getMethod("toString");
        Object result = resumeMethod.invoke(resume);
        System.out.println(result);
    }
}
