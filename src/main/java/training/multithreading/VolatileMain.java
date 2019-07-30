package training.multithreading;

public class VolatileMain {

    private static volatile int counter;

    public static void main(String[] args) {

        new SimpleWriter().start();
        new SimpleReader().start();

    }

    public static class SimpleWriter extends Thread {

        @Override
        public void run() {
            int writeLocal = counter;
            for (int i = 0; i < 10; i++){
                System.out.println(ColorScheme.BLUE + "Writer increments counter " + (writeLocal + 1));
                counter = ++writeLocal;

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static class SimpleReader extends Thread{

        @Override
        public void run() {

            int readLocal = counter;
            while (readLocal < 10){
                if (readLocal != counter){
                    System.out.println(ColorScheme.YELLOW + "Reader reads counter " + counter);
                    readLocal = counter;
                }

            }
        }
    }
}


