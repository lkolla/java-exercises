package concurrency.deadlock;

public class App {

    public static void main(String[] args) throws InterruptedException {

        DeadLockSimulator deadLockSimulator = new DeadLockSimulator();

        Runnable firstRunnable = () -> deadLockSimulator.first();
        Runnable secondRunnable = () -> deadLockSimulator.second();

        Thread first = new Thread(firstRunnable);
        first.start();

        Thread second = new Thread(secondRunnable);
        second.start();

        first.join();
        second.join();

    }

}
