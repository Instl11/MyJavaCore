package training.multithreading;

public class MainThread {
    public static void main(String[] args) throws InterruptedException {

        new ThreadImplement();
        System.out.println(ColorScheme.RED + "Главный поток " + Thread.currentThread().getName());

        new ThreadExtend();
        System.out.println(ColorScheme.RED + "Главный поток " + Thread.currentThread().getName());


    }
}
