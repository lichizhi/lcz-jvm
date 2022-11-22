package com.lcz.study.jvm.jmm;

public class T002_TestSync {
    synchronized void m() {}

    void n() {
        synchronized (this) {}
    }
}
