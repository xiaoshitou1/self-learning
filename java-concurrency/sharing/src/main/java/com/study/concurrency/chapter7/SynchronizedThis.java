package com.study.concurrency.chapter7;

public class SynchronizedThis {
    public static void main(String[] args) {
        ThisLock thisLock = new ThisLock();
        new Thread("T1") {
            @Override
            public void run() {
                thisLock.m1();
            }
        }.start();

        new Thread("T2") {
            @Override
            public void run() {
                thisLock.m2();
            }
        }.start();
    }
}

class ThisLock {

    //验证synchronized放在方法上其锁的this(即ThisLock的实例对象)
//    public synchronized void m1() {
//        System.out.println(Thread.currentThread().getName());
//        try {
//            Thread.sleep(10_000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    public synchronized void m2() {
//        System.out.println(Thread.currentThread().getName());
//        try {
//            Thread.sleep(10_000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }

    //锁是objec 对象
    private final Object MONITOR = new Object();  //自定义一个锁
//    public void m1() {
//        synchronized (MONITOR) {
//            System.out.println(Thread.currentThread().getName());
//            try {
//                Thread.sleep(10_000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//    public void m2() {
//        synchronized (MONITOR) {
//            System.out.println(Thread.currentThread().getName());
//            try {
//                Thread.sleep(10_000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//    }


    //两个线程的锁不是同一个锁，所以没有起到同步的作用
    public void m1() {
        synchronized (this) { //这里的锁是thisLock实例
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void m2() {
        synchronized (MONITOR) { //这里的锁是object对象
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
