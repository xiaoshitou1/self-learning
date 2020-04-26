package com.study.concurrency.chapter5;

public class ThreadJoin3 {

    public static void main(String[] args) throws InterruptedException {
        //create three threads to capture data

        long startTimestamp = System.currentTimeMillis();
        Thread t1 = new Thread(new CaptureRunnable("M1", 10000L));
        Thread t2 = new Thread(new CaptureRunnable("M2", 30000L));
        Thread t3 = new Thread(new CaptureRunnable("M3", 20000L));

        t1.start();
        t2.start();
        t3.start();

        //这里join的含义是让main线程等待采集数据的三个线程全部结束才开始往下执行，如果不加
        // 则会出现main线程已经走完了【即告诉用户数据收集完了】，但是三个收集数据的线程还在执行。所以需要用join
        t1.join();
        t2.join();
        t3.join();

        long endTimeStamp = System.currentTimeMillis();
        System.out.printf("Save data begin timestamp is: %s, end timestamp is: %s\n", startTimestamp, endTimeStamp); //告诉用户数据收集完了，需要用到子线程的处理结果
    }
}

class CaptureRunnable implements Runnable {
    private String machineName;
    private long spendTime;

    public CaptureRunnable(String machineName, long spendTime) {
        this.machineName = machineName;
        this.spendTime = spendTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(spendTime);
            System.out.printf(machineName + " completed data capture at timestamp [%s] and successfully.\n", System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
