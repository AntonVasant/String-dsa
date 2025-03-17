package dsscratch;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    class Node {
        int key;
        int value;
        int freq;
        Node next;
        Node prev;

        public Node(int key, int value){
            this.key = key;
            this.value = value;
            freq = 1;
        }
    }

    class DoublyLinkedList{
        Node head;
        Node tail;
        int size;

        public DoublyLinkedList(){
            head = new Node(-1,-1);
            tail = new Node(-1,-1);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void addNode(Node node){
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
            size++;
        }
        public void remove(Node node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            size--;
        }

        public Node removeLast(){
            if (size > 0){
                Node node  = tail.prev;
                remove(node);
                return node;
            }
            return null;
        }
    }

    int minFreq;
    Map<Integer, Node> nodeMap;
    Map<Integer, DoublyLinkedList> doublyLinkedListMap;
    int capacity;

    public LFUCache(int capacity) {
        minFreq = 0;
        nodeMap = new HashMap<>();
        doublyLinkedListMap = new HashMap<>();
        this.capacity = capacity;
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key))
            return -1;
        Node node = nodeMap.get(key);
        updateNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        if (nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.value = value;
            updateNode(node);
        }
        else {
            if (nodeMap.size() == capacity){
                DoublyLinkedList list = doublyLinkedListMap.get(minFreq);
                Node node = list.removeLast();
                if (node != null)
                    nodeMap.remove(node.key);
            }
            Node node = new Node(key, value);
            nodeMap.put(key, node);
            doublyLinkedListMap.computeIfAbsent(1, k -> new DoublyLinkedList()).addNode(node);
            minFreq = 1;
        }
    }

    private void updateNode(Node node){
        int oldFreq = node.freq;
        DoublyLinkedList list = doublyLinkedListMap.get(oldFreq);
        list.remove(node);
        if (minFreq == oldFreq && list.size == 0)
            minFreq++;
        node.freq++;
        doublyLinkedListMap.computeIfAbsent(node.freq, k -> new DoublyLinkedList()).addNode(node);
    }
}
