package training.multithreading.pingpong;

import training.multithreading.ColorScheme;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class PingPongLauncher {

    private static final Object lock = new Object();

    private static void ping() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            System.out.println(ColorScheme.RED + "Ping-" + i + " | " + Thread.currentThread().getName());

            lock.notify();
            if (i != 9) {
                lock.wait();
            }
        }
    }

    private static void pong() throws InterruptedException {

        for (int i = 0; i < 10; i++) {
            System.out.println(ColorScheme.BLUE + "Pong-" + i + " | " + Thread.currentThread().getName());

            if (i != 9) {
                lock.notify();
                lock.wait();
            } else return;
        }
    }


    public static void main(String[] args) {

        final Thread ping = new Thread(new Ping());
        final Thread pong = new Thread(new Pong());
        ping.start();
        pong.start();

        Deque<String> queue = new ArrayDeque<>();

        Stack<String> stack = new Stack<>();

    }

    public static class Ping implements Runnable {

        @Override
        public void run() {

            synchronized (lock) {
                try {
                    ping();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class Pong implements Runnable {

        @Override
        public void run() {

            synchronized (lock) {
                try {
                    pong();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
