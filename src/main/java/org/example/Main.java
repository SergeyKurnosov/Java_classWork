package org.example;

import org.example.task_1.Loader;
import org.example.task_2.Printer;

public class Main {

    static void main() throws InterruptedException {


        //============================================================================
        /*
        1.Класс Loader implements Runnable с полем boolean running = true и методом stop().
        В run() поток в цикле печатает «Загружаю...» и спит 300 мс, пока running == true.
        В main запусти поток, через 2 секунды вызови stop() и убедись, что поток завершился (join()).
        */
        Loader loader = new Loader();
        Thread thread1 = new Thread(loader);
        thread1.start();

        Thread.sleep(2000);
        loader.stop();
        thread1.join();
        System.out.println("Конец");
        //============================================================================
        /*
        2.Класс Printer с методом printDocument(String owner): печатает 5 строк вида Иван: строка 1, между строками sleep(50).
        Три потока (Иван, Мария, Олег) одновременно печатают через один Printer.Без synchronized строки разных документов перемешаются.
        Добавь synchronized на метод: каждый документ должен напечататься целиком.
        */

        String[] owners = {"Ivan", "Mariya", "Oleg"};
        Printer printer = new Printer();
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    printer.printDocument(owners[finalI]);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }).start();
        }


        //============================================================================

    }


}
