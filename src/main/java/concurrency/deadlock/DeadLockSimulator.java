package concurrency.deadlock;

public class DeadLockSimulator {

    private Object key1 = new Object();
    private Object key2 = new Object();

    public void first(){
        synchronized (key1){
            System.out.println(Thread.currentThread().getName() + " In first()");
            second();
        }
    }

    public void second(){
        synchronized (key2){
            System.out.println(Thread.currentThread().getName() + " In second()");
            third();
        }
    }

    public void third(){
        synchronized (key1){
            System.out.println(Thread.currentThread().getName() + " In third()");
        }
    }

}
