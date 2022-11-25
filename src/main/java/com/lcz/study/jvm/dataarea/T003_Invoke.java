package com.lcz.study.jvm.dataarea;

public class T003_Invoke {
    public static void main(String[] args) {
        T003_Invoke t = new T003_Invoke();
        t.m();
        t.n();
    }

    public final void m() {}
    private void n() {}
}
