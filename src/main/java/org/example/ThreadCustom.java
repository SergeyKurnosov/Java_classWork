package org.example;

public class ThreadCustom implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " -> " + Thread.currentThread().getPriority());
        }
    }
}
