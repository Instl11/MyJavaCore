package training.multithreading.creating_threads;

import training.multithreading.ColorScheme;

public class ThreadImplement implements Runnable {

    private Thread t;

    ThreadImplement(){
        t = new Thread(this, "Implement поток");
        System.out.println(ColorScheme.BLUE + "Дочерний поток " + t);
        t.start();
    }

    @Override
    public void run(){
        for (int i = 1; i < 6; i++){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(ColorScheme.BLUE + "INFO - " + Thread.currentThread().getName() + " " + i);
        }
    }
}
