package org.example.task_2;

public class Printer {

    public synchronized void printDocument(String owner) throws InterruptedException {
       // System.out.println("fretrrhedf");
        for (int i = 1; i <=5 ; i++) {
            System.out.println(owner + ":строка " + i);
            Thread.sleep(50);
        }
    }
}
