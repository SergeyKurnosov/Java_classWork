package org.example;

import javax.swing.*;
import java.awt.*;



public class Main {

    static int counter = 0;
    static int count_step = 100_000;
    static void main() throws InterruptedException {


        //============================================================================
        /*
        1.Создай три потока через Runnable (один через лямбду, один через отдельный класс). Каждому задай имя
        через setName и приоритет: MIN_PRIORITY, NORM_PRIORITY, MAX_PRIORITY. Каждый печатает своё имя и приоритет 5 раз с Thread.sleep(100).
        В main дождись всех через join и напечатай «Все завершились».
         */

        Thread oneThread = new Thread(new ThreadCustom());
        Thread twoThread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + " -> " + Thread.currentThread().getPriority());
                }
            }
        });
        Thread threeThread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName() + " -> " + Thread.currentThread().getPriority());
            }
        });

        oneThread.setName("one");
        twoThread.setName("two");
        threeThread.setName("three");

        oneThread.setPriority(Thread.MIN_PRIORITY);
        twoThread.setPriority(Thread.NORM_PRIORITY);
        threeThread.setPriority(Thread.MAX_PRIORITY);

        oneThread.start();
        twoThread.start();
        threeThread.start();

        oneThread.join();
        twoThread.join();
        threeThread.join();

        System.out.println("Все завершились");


        //============================================================================
        /*
        2.Создай статическое поле static int counter = 0. Запусти 2 потока, каждый делает counter++ 100 000 раз.
        Дождись обоих через join и выведи counter.
        Повтори запуск 5 раз в цикле (обнуляй counter перед каждым запуском). Затем замени 100 000 на 100 и снова запусти
         */

        Runnable task = ()->{
            for (int i = 0; i < count_step ; i++) {
                counter++;
            }
        };

        Thread one = new Thread(task), two = new Thread(task);
        one.start();
        two.start();
        one.join();
        two.join();
        System.out.println(counter);
        System.out.println();


        forsThread(task);
        System.out.println();
        count_step = 100;
        forsThread(task);

        //============================================================================

    }

    public static void forsThread(Runnable task) throws InterruptedException {
        for (int i = 0; i < 5; i++) {

            Thread thread1 = new Thread(task);
            Thread thread2 = new Thread(task);
            counter = 0;
            thread1.start();
            thread2.start();

            thread1.join();
            thread2.join();

            System.out.println(counter);
        }
    }

}
