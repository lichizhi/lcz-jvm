package com.lcz.study.jvm.gc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class T002_TestGC {

    static class User {
        BigDecimal bigDecimal = new BigDecimal("0.0");
        String name = "hello";
        String name2 = "hello";
        String name3 = "hello";
        int age = 12;

        public void m() {
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (; ; ) {
            User o;
            List<User> users = new ArrayList<>();
            for (int i = 0; i < 100000; i++) {
                o = new User();
                o.m();
                users.add(o);
            }
            Thread.sleep(2);
        }

    }

}
