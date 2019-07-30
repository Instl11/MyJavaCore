package training.multithreading;

public class FibonachiConcurrent {

    private static int previous = 0;
    private static int current = 1;

    public static void main(String[] args) {
        Thread th1 = new Thread(new FibbonachiRunner());
        Thread th2 = new Thread(new FibbonachiRunner());
        th1.start();
        th2.start();
    }

    private static synchronized void calcNext() {
        int next = previous + current;
        previous = current;
        current = next;
        System.out.print(current + ", ");
    }

    private static class FibbonachiRunner implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                calcNext();
            }
        }
    }
}
