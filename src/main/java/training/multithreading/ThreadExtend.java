package training.multithreading;

public class ThreadExtend extends Thread {

    public ThreadExtend() {
        super("Extend поток");
        System.out.println(ColorScheme.YELLOW + "Дочерний поток " + this);
        start();
    }

    @Override
    public void run() {
        for (int i = 1; i < 6; i++){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(ColorScheme.YELLOW + "INFO - " + this.getName() + " " + i);
        }
    }
}
