package training.multithreading.producer_consumer;

import training.multithreading.ColorScheme;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
    private static String[] messages = {
            "Whose woods these are I think I know.",
            "His house is in the village though;",
            "He will not see me stopping here",
            "To watch his woods fill up with snow.",
            "My little horse must think it queer",
            "To stop without a farmhouse near",
            "Between the woods and frozen lake",
            "The darkest evening of the year.",
            "He gives his harness bells a shake",
            "To ask if there is some mistake.",
            "The only other sound’s the sweep",
            "Of easy wind and downy flake.",
            "The woods are lovely, dark and deep,",
            "But I have promises to keep,",
            "And miles to go before I sleep,",
            "And miles to go before I sleep.",
            "DONE"
    };

    public static void main(String[] args) {
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }

    private static class Producer implements Runnable{

        @Override
        public void run() {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void produce() throws InterruptedException {
            Random r = new Random();
            for (int i = 0; i < messages.length; i++){
                queue.put(messages[i]);
                System.out.println(ColorScheme.GREEN + "Producing " + messages[i] + ". Queue size is: " + queue.size());
                Thread.sleep(r.nextInt(3000));
            }
        }
    }

    private static class Consumer implements Runnable{

        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void consume() throws InterruptedException {
            Random r = new Random();
            while (true){
                String message = queue.take();
                System.out.println(ColorScheme.RED + "Consuming " + message + " . Queue size is " + queue.size());

                if (!"DONE".equals(message)){
                    Thread.sleep(r.nextInt(1000));
                }else
                    return;
            }
        }
    }
}
