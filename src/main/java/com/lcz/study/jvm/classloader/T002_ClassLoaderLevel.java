package com.lcz.study.jvm.classloader;

/**
 * 父加载器不是继承关系！！！也不是 “类加载器的加载器”。从源码角度来说，就是一个指定的成员变量类加载器对象
 * 启动类加载器 (Boot ClassLoader) 由 Java 实现，父加载器为 null；
 * 平台类加载器 (Platform ClassLoader) 由 Java 实现，父加载器为 Boot ClassLoader；
 * 应用程序类加载器 (Application ClassLoader) 由 Java 实现，父加载器为 Platform ClassLoader；
 * 自定义类加载器 (Custom ClassLoader) 由用户基于 Java 实现，父加载器为 Application ClassLoader.
 */
public class T002_ClassLoaderLevel {
    public static void main(String[] args) {
        System.out.println(T002_ClassLoaderLevel.class.getClassLoader());
        // 类加载器的加载器
        System.out.println(T002_ClassLoaderLevel.class.getClassLoader().getClass().getClassLoader());
        // 类加载器的父加载器
        System.out.println(T002_ClassLoaderLevel.class.getClassLoader().getParent());
        System.out.println(T002_ClassLoaderLevel.class.getClassLoader().getParent().getParent());

    }
}
