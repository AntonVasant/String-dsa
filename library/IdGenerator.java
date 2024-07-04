package library;


import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private static final AtomicLong current = new AtomicLong();
    public static long getNextId(){
        return current.incrementAndGet();
    }
}
