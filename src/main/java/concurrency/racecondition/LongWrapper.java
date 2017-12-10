package concurrency.racecondition;

public class LongWrapper {

    private Object key = new Object();

    private long l;

    public LongWrapper(long l){
        this.l = l;
    }

    public long getLong(){
        return l;
    }

    public void incrementLong(){

        synchronized (key){
            l = l + 1;
        }

    }

}
