package dsscratch;

import java.util.HashMap;
import java.util.Map;
class Node{
    int key;
     int value;
     Node prev;
   Node next;

    public Node(int key,int value){
        this.value = value;
        this.key = key;
        prev = null;
        next = null;
    }
}
public class LRU {
    private int capacity;
    private Map<Integer,Node> cache;
    private Node head;
    private Node tail;


    public LRU(int capacity){
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key){
        if (cache.containsKey(key)){
            Node node = cache.get(key);
            remove(node);
            moveToHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key,int val){
        if (cache.containsKey(key)){
            Node node = cache.get(key);
            node.value = val;
            remove(node);
            moveToHead(node);
        }
        else {
            if (cache.size() == capacity){
                cache.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node(key,val);
            cache.put(key,newNode);
            moveToHead(newNode);
        }
    }

    private void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node){
        Node temp = head.next;
        temp.prev = node;
        head.next = node;
        node.prev = head;
        node.next = temp;
    }
}
