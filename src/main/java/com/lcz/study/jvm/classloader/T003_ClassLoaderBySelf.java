package com.lcz.study.jvm.classloader;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;

public class T003_ClassLoaderBySelf extends ClassLoader {
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File file = new File("D:\\test\\", name.replaceAll("\\.", "\\\\").concat(".class"));
        try {
            FileInputStream fis = new FileInputStream(file);
            ByteArrayOutputStream bao = new ByteArrayOutputStream();
            int b;
            while ((b = fis.read()) != -1) {
                bao.write(b);
            }

            byte[] bytes = bao.toByteArray();
            bao.close();
            fis.close();

            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException,
            InvocationTargetException, InstantiationException {
        ClassLoader myLoader = new T003_ClassLoaderBySelf();
        Class<?> clazz = myLoader.loadClass("com.lcz.study.jvm.classloader.Hello");
        Hello hello = (Hello) clazz.getDeclaredConstructor().newInstance();
        hello.m();
    }
}
