package concurrency.voletile;

import java.util.Date;
import java.util.stream.IntStream;

public class VolatileExample {

    private volatile int i = 0;

    public void increment(){
        ++i;
    }

    public void display(){
        System.out.println(i  + " @"+ new Date());
    }

    public static void main(String[] args) throws InterruptedException {

        VolatileExample volatileExample = new VolatileExample();

        Runnable incrementTask = () -> {
            IntStream.range(1, 100).forEach(index -> volatileExample.increment());
        };

        Runnable displayTask = () -> {
            IntStream.range(1, 100).forEach(index -> volatileExample.display());
        };

        Thread incrementT = new Thread(incrementTask);
        Thread displayT = new Thread(displayTask);

        incrementT.start();
        displayT.start();

        incrementT.join();
        displayT.join();

        System.out.println("current value:" + volatileExample.i);


    }


}
