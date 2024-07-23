package dsscratch;

public class Main {
    public static void main(String[] a){
        LRU lru = new LRU(2);
        lru.put(5,6);
        lru.put(4,2);
        lru.put(6,7);
        lru.put(9,3);
        lru.put(7,8);
        lru.put(3,3);
        System.out.println(lru.get(7));
    }
}
