package training.multithreading.producer_consumer;

import training.multithreading.ColorScheme;

public class WaitNotifyExample {

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
        MessageLock message = new MessageLock();
        new Thread(new Producer(message)).start();
        new Thread(new Consumer(message)).start();

    }

    public static class Producer implements Runnable {

        private final MessageLock message;

        private static boolean mark = true;

        public Producer(MessageLock message) {
            this.message = message;
        }

        @Override
        public void run() {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void produce() throws InterruptedException {

            for (int i = 0; i < messages.length; i++) {
                synchronized (message) {
                    message.setMessage(messages[i]);
                    System.out.println(ColorScheme.RED + "Producing message " + messages[i]);

                    message.notify();

                    if (i != messages.length - 1){
                        message.wait();
                    } else
                        mark = !mark;
                }
            }
        }
    }

    public static class Consumer implements Runnable {

        private final MessageLock message;

        public Consumer(MessageLock message) {
            this.message = message;
        }

        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        private void consume() throws InterruptedException {

            while (true) {
                synchronized (message) {
                    System.out.println(ColorScheme.BLUE + "Consuming message " + message.getMessage());

                    if (Producer.mark){
                        message.notify();
                        message.wait();
                    } else
                        return;
                }
            }
        }
    }
}
