package com.lcz.study.jvm.classloader;

public class T004_LazyLoader {

    static {
        System.out.println("T004_LazyLoader 的静态代码块加载了");
    }

    public static void main(String[] args) {
        new Demo1();
        System.out.println("===================");
        Demo2 demo2 = null;
    }

    static class Demo1 {
        static {
            System.out.println("demo1 load");
        }

        public Demo1() {
            System.out.println("demo1 初始化了");
        }

    }

    static class Demo2 {
        static {
            System.out.println("demo2 load");
        }

        public Demo2() {
            System.out.println("demo2 初始化了");
        }
    }

}
