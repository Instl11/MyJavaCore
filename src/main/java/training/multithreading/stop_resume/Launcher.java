package training.multithreading.stop_resume;

public class Launcher {
    public static void main(String[] args) throws InterruptedException {

        NewThread ob1 = new NewThread("One");
        NewThread ob2 = new NewThread("Two");

        Thread.sleep(1000);
        ob1.mysuspend();
        System.out.println("Приостановка потока 1");
        Thread.sleep(1000);
        ob1.myresume();
        System.out.println("Возобновление потока 1");

        ob1.t.join();
        ob2.t.join();

        System.out.println("Главный поток завершен");

    }
}
