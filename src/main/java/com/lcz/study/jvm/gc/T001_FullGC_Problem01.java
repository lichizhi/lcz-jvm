package com.lcz.study.jvm.gc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 模拟风控
 * 从数据库中读取信用数据，套用模型，并把结果进行记录和传输
 */
public class T001_FullGC_Problem01 {

    private static class CardInfo {
        BigDecimal price = new BigDecimal("0.0");
        String name = "张三";
        int age = 5;
        Date birthDate = new Date();

        public void m() {}
    }

    static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(20, new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void main(String[] args) throws InterruptedException {
        for (;;) {
            modelFit();
            Thread.sleep(100);
        }
    }

    private static void modelFit() {
        List<CardInfo> cardInfos = getAllCardInfos();
        for (CardInfo cardInfo : cardInfos) {
            executor.scheduleWithFixedDelay(cardInfo::m, 3, 2, TimeUnit.SECONDS);
        }
    }

    private static List<CardInfo> getAllCardInfos() {
        List<CardInfo> taskList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            CardInfo cardInfo = new CardInfo();
            taskList.add(cardInfo);
        }

        return taskList;
    }

}
