package training.multithreading.daemon;

import training.multithreading.ColorScheme;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class Launcher {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(ColorScheme.RED + "Starting main thread");
        boolean daemon = true;
        GDCRunnable r = new GDCRunnable(daemon);

        runWithExecutors(r, daemon);

        System.out.println(ColorScheme.RED + "Leaving main thread");
    }

    public static void runInOneThread(GDCRunnable r){

        Thread th = new Thread(r);
        th.start();
    }

    private static void runWithExecutors(GDCRunnable r, boolean isDaemon) throws InterruptedException {

        ThreadFactory factory = r1 -> {
            Thread thread = new Thread(r1);
            if (isDaemon)
                thread.setDaemon(isDaemon);
            return thread;
        };
        ExecutorService ex = Executors.newFixedThreadPool(2, factory);

        for (int i = 0; i<5; i++){
            ex.execute(r);
        }
        ex.shutdown();
        ex.awaitTermination(30, TimeUnit.SECONDS);
    }
}
