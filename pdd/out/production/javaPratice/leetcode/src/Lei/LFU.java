package Lei;

import java.util.HashMap;
import java.util.Map;

public class LFU {
    Map<Integer, Node> cache;
    DoubleLinkedList firstLinkedList;
    DoubleLinkedList lastLinkedList;
    int size;
    int capacity;

    public LFU(int capacity){
        cache = new HashMap<>(capacity);
        firstLinkedList = new DoubleLinkedList();
        lastLinkedList = new DoubleLinkedList();
        firstLinkedList.next = lastLinkedList;
        lastLinkedList.pre = firstLinkedList;
        this.capacity = capacity;
    }

    public int get(int key){
        Node node = cache.get(key);
        if(node == null) return -1;
        freqInc(node);
        return  node.value;
    }

    public void put(int key, int value){
        if(capacity == 0) return;
        Node node = cache.get(key);
        if(node != null) {
            node.value = value;
            freqInc(node);
        }else{
            if(size == capacity){
                cache.remove(lastLinkedList.pre.tail.pre.key);
                lastLinkedList.remove(lastLinkedList.pre.tail.pre);
                size--;
                if(lastLinkedList.pre.head.next == lastLinkedList.pre.tail)
                    removeDoubleLinkedList(lastLinkedList.pre);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            if(lastLinkedList.pre.freq != 1){
                DoubleLinkedList newDoubleLinkedList = new DoubleLinkedList(1);
                addDoubeLinkedList(newDoubleLinkedList, lastLinkedList.pre);
                newDoubleLinkedList.add(newNode);
            }else
                lastLinkedList.pre.add(newNode);
            size++;
        }

    }

    public void freqInc(Node node){
        //将node从freq对应的链表里移除，如果链表空了就删除链表
        DoubleLinkedList linkedList = node.doubleLinkedList;
        DoubleLinkedList preLinkedList = linkedList.pre;
        linkedList.remove(node);
        if(linkedList.head.next == linkedList.tail)
            removeDoubleLinkedList(linkedList);
        //将node加入新freq对应的链表，如果不存在，则先创建链表
        node.freq++;
        if(preLinkedList.freq != node.freq){
            DoubleLinkedList newDoubleLinkedList = new DoubleLinkedList(node.freq);
            addDoubeLinkedList(newDoubleLinkedList, preLinkedList);
            newDoubleLinkedList.add(node);
        }else
            preLinkedList.add(node);

    }

    void addDoubeLinkedList(DoubleLinkedList newDoubleLinkedList, DoubleLinkedList preDoubleLinkedList){
        newDoubleLinkedList.next = preDoubleLinkedList.next;
        newDoubleLinkedList.next.pre = newDoubleLinkedList;
        preDoubleLinkedList.next = newDoubleLinkedList;
        newDoubleLinkedList.pre = preDoubleLinkedList;
    }

    void removeDoubleLinkedList(DoubleLinkedList doubleLinkedList){
        doubleLinkedList.pre.next = doubleLinkedList.next;
        doubleLinkedList.next.pre = doubleLinkedList.pre;
    }

    public static void main(String[] args) {
        LFU cache = new LFU(2);
        cache.put(1,1);
        cache.put(2,2);
        cache.get(1);
        cache.put(3,3);
        cache.get(2);
        cache.get(3);
        cache.put(4,4);
        cache.get(1);
        cache.get(3);
        cache.get(4);

    }
}

class Node{
    int key;
    int value;
    int freq = 1;
    Node pre;
    Node next;
    DoubleLinkedList doubleLinkedList;
    public Node(){}

    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
}

class DoubleLinkedList{
    int freq ;
    DoubleLinkedList pre;
    DoubleLinkedList next;
    Node head;
    Node tail;
    public DoubleLinkedList(){
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
    }

    public DoubleLinkedList(int freq){
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.freq = freq;
    }

    void remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    void add(Node node){
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
        node.doubleLinkedList = this;
    }
}
