package heap;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

class MinStack {
    Deque<Integer> A,B;
    /** initialize your data structure here. */
    public MinStack() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    public void push(int x) {
        A.add(x);
        if(B.isEmpty() || B.peek() >= x){
            B.push(x);
        }
    }

    public void pop() {
        if(A.poll().equals(B.peek())){
            B.poll();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }

    public static void main(String[] args) {

        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addLast(5);
        deque.addLast(6);
        deque.addLast(7);
        deque.addLast(8);
        deque.poll();
        MinStack ms = new MinStack();
        ms.push(0);
        ms.push(1);
        ms.push(0);
        int min = ms.min();
        ms.pop();
        int min2 = ms.min();
        int[] res = {min,min2};
        System.out.println(Arrays.toString(res));
    }
}
