package concurrency.producer.consumer;

import java.util.stream.IntStream;

public class App {

    private static Object key = new Object();

    private static int[] buffer;
    private static int count;


    static class Producer {

        void produce(){

            synchronized (key){
                if (isFull(buffer)){
                    try {
                        key.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                buffer [count++] = 1;
                key.notify();
            }




        }
    }

    static class Consumer {

        void consume(){

            synchronized (key){
                if (isEmpty(buffer)){
                    try {
                        key.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                buffer[--count] = 0;
                key.notify();
            }

        }
    }

    static boolean isFull(int[] buffer){
        return count == buffer.length;
    }

    static boolean isEmpty(int[] buffer){
        return count == 0;
    }

    public static void main(String... args) throws InterruptedException {

        buffer = new int[10];
        count = 0;

        Producer producer = new Producer();
        Consumer consumer = new Consumer();

        Runnable producerTask = () -> {

            IntStream.range(1,50).forEach(index -> producer.produce());

        };

        Runnable consumerTask = () -> {
            IntStream.range(1,45).forEach(index -> consumer.consume());
        };

        Thread producerThread = new Thread(producerTask);
        Thread consumerThread = new Thread(consumerTask);

        producerThread.start();
        consumerThread.start();


        producerThread.join();
        consumerThread.join();

        System.out.println("count: "+count);


    }

}
