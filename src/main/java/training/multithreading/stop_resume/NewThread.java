package training.multithreading.stop_resume;

public class NewThread implements Runnable {
    private String name;
    Thread t;
    private boolean suspendFlag;

    NewThread(String name) {
        this.name = name;
        t = new Thread(this, name);
        System.out.println("Новый поток");
        suspendFlag = false;
        t.start();
    }

    public void run() {
        for (int i = 15; i > 0; i--) {
            System.out.println(name + " " + i);
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (this) {
                while (suspendFlag) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println(name + " завершен");
    }

    synchronized void mysuspend() {
        suspendFlag = true;
    }

    synchronized void myresume() {
        suspendFlag = false;
        notify();
    }
}
