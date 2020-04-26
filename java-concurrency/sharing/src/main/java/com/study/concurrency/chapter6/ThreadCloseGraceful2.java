package com.study.concurrency.chapter6;

/**
 * 采用优雅的方式结束线程生命周期：
 *  方法2：使用
 */
public class ThreadCloseGraceful2 {

    private static class Worker extends Thread {

        @Override
        public void run() {
            while (true) {
//                try {
//                    Thread.sleep(1);
//                } catch (InterruptedException e) {
//                    break;
//                }

                if (Thread.interrupted()) {
                    break;
                }
            }
            //------------------
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

        worker.interrupt();
    }
}
