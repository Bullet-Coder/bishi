package heap;

import java.util.LinkedList;

public class CQueue {
    LinkedList<Integer> A,B;
    public CQueue() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }

    public void appendTail(int value) {
        A.add(value);
    }

    public int deleteHead() {
        if(!B.isEmpty()) return B.removeLast();
        if(A.isEmpty()) return -1;
        while(!A.isEmpty()) B.addLast(A.removeLast());
        return B.removeLast();
    }

    public static void main(String[] args) {
        CQueue cq = new CQueue();
        cq.appendTail(1);
        cq.appendTail(2);
        cq.appendTail(3);
        cq.appendTail(4);
        cq.appendTail(5);
        cq.appendTail(6);
        int a = cq.deleteHead();
        int b = cq.deleteHead();
    }
}
