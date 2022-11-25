package com.lcz.study.jvm.dataarea;

// -XX:-DoEscapeAnalysis -XX:-EliminateAllocations -XX:-UseTLAB
// 关闭逃逸分析            关闭标量替换               关闭线程本地分配
public class T005_TestTLAB {
//    User user;

    // 线程私有小对象、支持标量替换
    static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    void alloc(int i) {
        // 无逃逸
        new User(i, "name " + i);
//        user = new User(i, "name " + i); // 有逃逸
    }

    public static void main(String[] args) {
        T005_TestTLAB tlab = new T005_TestTLAB();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000_0000; i++) {
            tlab.alloc(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
