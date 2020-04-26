package com.study.concurrency.chapter6;

/**
 * 采用优雅的方式结束线程生命周期：
 *  方法1：设置一个开关
 */
public class ThreadCloseGraceful {

    private static class Worker extends Thread {
        private volatile boolean start = true;

        @Override
        public void run() {
            while (start) {

            }
        }

        public void shutdown() {
            this.start = false;
        }
    }

    public static void main(String[] args) {
        Worker worker = new Worker();
        worker.start();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        worker.shutdown();
    }
}
