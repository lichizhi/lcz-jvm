package com.lcz.study.jvm.gc;

import java.util.LinkedList;
import java.util.List;

public class HelloGC {
    public static void main(String[] args) {
        System.out.println("hello gc");
        List<byte[]> list = new LinkedList<>();
        for (;;) {
            list.add(new byte[1024 * 1024]);
        }

    }
}
