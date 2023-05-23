package Lei;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class DLinkedNode{
        int key;
        int val;
        DLinkedNode pre;
        DLinkedNode next;
        public DLinkedNode(){};
        public DLinkedNode(int key, int value){this.key = key; this.val = val;}

    }

    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;
    public LRUCache(int capacity) {
        this.size = 0;
        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.next = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        DLinkedNode node = cache.get(key);
        if(node == null)
            return -1;
        moveToHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        DLinkedNode node = cache.get(key);
        if(node != null){
            node.val = value;
            moveToHead(node);
        }else{
            DLinkedNode newNode = new DLinkedNode(key, value);
            cache.put(key, newNode);
            addToHead(newNode);
            size++;
            if(size > capacity){
                DLinkedNode removed = removeTail(tail.pre);
                cache.remove(removed.key);
                size--;
            }
        }
    }

    public void moveToHead(DLinkedNode node){
        removeNode(node);
        addToHead(node);
    }

    public void removeNode(DLinkedNode node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    public void addToHead(DLinkedNode node){
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    public DLinkedNode removeTail(DLinkedNode node){
        node.pre.next = tail;
        tail.pre = node.pre;
        return node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);
    }
}
