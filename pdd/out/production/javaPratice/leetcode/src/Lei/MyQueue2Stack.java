package Lei;

import java.util.LinkedList;
import java.util.Queue;

public class MyQueue2Stack {
    Queue<Integer> queue1;
    Queue<Integer> queue2;
    public MyQueue2Stack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int x) {
        queue2.offer(x);
        while(!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyQueue2Stack myQueue = new MyQueue2Stack();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        int t = myQueue.top();
        int p = myQueue.pop();
        myQueue.empty();

    }
}
