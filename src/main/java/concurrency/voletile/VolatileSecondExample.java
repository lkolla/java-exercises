package concurrency.voletile;

import java.util.Date;
import java.util.stream.IntStream;

public class VolatileSecondExample {

    private volatile int x, y, r1, r2;

    private Object lock = new Object();

    public void first(){

        x = 1;

        synchronized (lock){
            y = 1;
        }

    }

    public void second(){


        synchronized (lock){
            r1 = y;
        }

        r2 = x;
    }

    public static void main(String[] args) throws InterruptedException {

        VolatileSecondExample volatileExample = new VolatileSecondExample();

        Runnable firstTask = () -> {
            volatileExample.first();
        };

        Runnable secondTask = () -> {
            volatileExample.second();
        };

        Thread firstT = new Thread(firstTask);
        Thread secondT = new Thread(secondTask);


        firstT.start();secondT.start();


        secondT.join();
        firstT.join();

        System.out.println("current value:" + volatileExample.r2);


    }


}
