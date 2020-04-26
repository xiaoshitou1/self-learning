package com.study.concurrency.chapter1;

public class TryConcurrency {

    public static void main(String[] args) {
        new Thread("READ-Thread"){
            @Override
            public void run() {
                readFromDatabase();
            }
        }.start();

        new Thread("WRITE-Thread"){
            @Override
            public void run() {
                writeDataToFile();
            }
        }.start();


    }

    private static void writeDataToFile() {
        try {
            System.out.println("write data to file");
            Thread.sleep(1000*200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void readFromDatabase() {
        try {
            System.out.println("read data from database");
            Thread.sleep(1000*200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
