package dsscratch;

import java.util.HashMap;
import java.util.Map;

class Node{
    int value;
    int key;
    Node next;
    Node prev;

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }

    public Node(int key) {

    }
}
class LRUCache {
    private int cap;
    private Map<Integer, Node> map;

    Node head;
    Node tail;
    LRUCache(int cap) {
        this.cap = cap;
        map = new HashMap<>();
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            remove(map.get(key));
            addToTop(map.get(key));
            return map.get(key).value;
        }
        return -1;
    }

    public void set(int key, int value) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            remove(node);
            addToTop(node);
        }
        else {
            if (map.size() == cap){
                removeTail();
            }
            Node node = new Node(key, value);
            map.put(key, node);
            addToTop(node);
        }
    }

    private void removeTail(){
        Node node = tail.prev;
        remove(node);
        map.remove(node.key);
    }

    private void addToTop(Node node){
        node.next = head.next;
        head.next  = node;
        node.prev = head;
        node.next.prev = node;
    }

    private void remove(Node node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

}