package training.multithreading.locks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static training.multithreading.ColorScheme.*;

public class LockReentrantUsage {

    private static final Lock monitor = new ReentrantLock();

    private static final Condition canRead = monitor.newCondition();
    private static final Condition canWrite = monitor.newCondition();

    private static int buffer = 0;
    private static boolean isEmpty = true; //проверяет пустой ли buffer

    public static void main(String[] args) {

        new Thread(LockReentrantUsage::write).start();
        new Thread(LockReentrantUsage::read).start();

    }

    private static void write() {
        for (int i = 0; i < 10; i++) {
            monitor.lock();
            try {
                while (!isEmpty){
                    canWrite.await();
                }
                buffer++;
                isEmpty = false;
                System.out.println(RED + "Producing " + buffer);
                canRead.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                monitor.unlock();
            }
        }
    }

    private static void read() {
        for (int i = 0; i < 10; i++) {
            monitor.lock();
            try {
                while (isEmpty){
                    canRead.await();
                }
                isEmpty = true;
                System.out.println(BLUE + "Consuming " + buffer);
                canWrite.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                monitor.unlock();
            }
        }
    }
}