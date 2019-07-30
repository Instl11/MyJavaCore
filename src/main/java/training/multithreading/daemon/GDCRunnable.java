package training.multithreading.daemon;

import training.multithreading.ColorScheme;

import java.util.Random;

public class GDCRunnable extends Random implements Runnable {

    private boolean daemon;
    public GDCRunnable(boolean daemon) {
        this.daemon = daemon;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(ColorScheme.BLUE + "Starting " + threadName);
        for (int i = 0; i < 10000000; i++) {
                int a = nextInt();
                int b = nextInt();

                if (i % 10000 == 0) {
                    int gcd = computeGCD(a, b);
                    if (gcd > 5)
                        System.out.println(ColorScheme.PURPLE + "Running in " + threadName + " | GCD of: " + a + " and " + b + " is " + gcd);
                }
            }
        System.out.println(ColorScheme.BLUE + "Leaving the thread " + threadName);
    }

    private int computeGCD(int num1, int num2) {
        if (num2 == 0)
            return num1;
        else
            return computeGCD(num2, num1 % num2);
    }
}
