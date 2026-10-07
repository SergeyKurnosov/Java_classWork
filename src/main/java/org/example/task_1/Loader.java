package org.example.task_1;

public class Loader implements Runnable {
    boolean running = true;

    @Override
    public void run() {
        while (running) {
            try {
                System.out.println("«Загружаю...»");
                Thread.sleep(300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void stop() {
        this.running = false;
    }

}
