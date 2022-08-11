package com.dunn.juc.demos;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @description:
 * @author: Dunn
 * @create: 2022-08-02 15:47
 */
@Data
@Slf4j
public class Demos {

    /**
     * 创建线程方式1
     */
    public static void createThread1() {
        Thread thread = new Thread("我是线程1") {
            @Override
            public void run() {
                log.info(Thread.currentThread().getName());
                log.info("创建线程方式1");
            }
        };
        thread.start();

    }

    /**
     * 创建线程方式2
     */
    public static void createThread2() {
        Runnable runnable = () -> {
            log.info(Thread.currentThread().getName());
            log.info("创建线程方式2");
        };

        Thread thread = new Thread(runnable, "我是线程2");
        thread.start();

    }

    /**
     * 创建线程方式3
     */
    public static void createThread3() throws ExecutionException, InterruptedException {
        FutureTask<String> future = new FutureTask<>(() -> {
            log.info("hello future");
            Thread.sleep(3000);
            return "result future";
        });

        Thread thread = new Thread(future, "创建线程方式3");
        thread.start();
        String s = future.get();
        log.info(s);
    }

    static int r = 0;

    private static void join1() throws InterruptedException {
        log.debug("开始");
        Thread t1 = new Thread(() -> {
            log.debug("开始");
            try {
                Thread.sleep(5 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("结束");
            r = 10;
        });
        t1.setName("线程1");
        t1.start();
        t1.join(0);
        log.debug("结果为:r={}", r);
        log.debug("结束");
    }

    /**
     * interrupt方法会将线程阻塞状态变为可运行状态
     * interrupt方法不是真的中断线程，而是告诉线程你该中断了，具体中不中断是由线程自己决定
     */
    private static void interrupt1() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                Thread.currentThread().join(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            while (true) {
                log.info("执行中");
            }

        });
        t1.setName("线程1");
        t1.start();
        // interrupt方法会将线程阻塞状态变为可运行状态
        // 如果把interrupt方法注释掉，线程1会睡眠6秒后执行
        t1.interrupt();
        log.info("结束");
    }

    /**
     * 守护线程：（比如GC垃圾回收线程），
     * 只要其它非守护线程运行结束了，即使守护线程的代码没有执行完，也会强制结束。
     */
    private static void daemon1() throws InterruptedException {
        log.info("开始");
        Thread t1 = new Thread(() -> {
            log.info("开始");
            while (true) {
                log.info("执行中");
            }
        }, "线程1");
        t1.setDaemon(true);
        t1.start();
        Thread.sleep(1);
        log.info("结束");
    }

    private static void unsafeTest() {
        TicketWindow ticketWindow = new TicketWindow(2000);
        List<Thread> list = new ArrayList<>();
        // 用来存储买出去多少张票
        List<Integer> sellCount = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            Thread t = new Thread(() -> {
                // 分析这里的竞态条件
                int count = ticketWindow.sell(randomAmount());
                sellCount.add(count);
            });
            list.add(t);
            t.start();
        }
        list.forEach((t) -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        // 买出去的票求和
        System.out.println(1);
        log.debug("selled count:{}", sellCount.stream().mapToInt(c -> c).sum());
        // 剩余票数
        log.debug("remainder count:{}", ticketWindow.getCount());
    }

    // Random 为线程安全
    static Random random = new Random();

    // 随机 1~5
    public static int randomAmount() {
        return random.nextInt(5) + 1;

    }


    public static void main(String[] args) throws Exception {

    }


}

class TicketWindow {
    private int count;

    public TicketWindow(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public int sell(int amount) {
        if (this.count >= amount) {
            this.count -= amount;
            return amount;
        } else {
            return 0;
        }
    }
}