package com.lcz.study.jvm.dataarea;

public class T004_Dynamic {
    public static void main(String[] args) {
        I i1 = C::n;

        System.out.println(i1.getClass());
        i1.m();

        I i2 = new A();
        i2.m();
        System.out.println(i2.getClass());
    }

    @FunctionalInterface
    public interface I {
        void m();
    }

    public static class C {
        public static void n() {
            System.out.println("hello");
        }
    }

    public static class A implements I {
        @Override
        public void m() {
            C.n();
        }
    }
}
