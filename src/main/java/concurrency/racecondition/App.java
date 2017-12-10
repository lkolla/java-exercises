package concurrency.racecondition;

public class App {
    public static void main(String[] args) throws InterruptedException{

        System.out.println("Inside RaceConditionExample");

        LongWrapper wrapper = new LongWrapper(0);

        Runnable r = () -> {

            for(int i = 0; i < 1_000; i++){
                wrapper.incrementLong();
            }
        };


        Thread[] threads = new Thread[1000];

        for(int i = 0; i < 1_000; i++){
            threads[i] = new Thread(r);
            threads[i].start();
        }

        for(int i = 0; i < 1_000; i++){
            threads[i].join();
        }

        System.out.println(wrapper.getLong());


    }

}
