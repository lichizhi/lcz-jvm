package com.lcz.study.jvm.dataarea;

public class T001_TestIPlusPlus {
    public static void main(String[] args) {
        int i = 8;
//        i = i++; // 8
        i = ++i; // 9
        System.out.println(i);
    }
}
