package Lei;

import java.util.Stack;

public class MyStack2Queue
{
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyStack2Queue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        fillStack();

        return stack2.pop();
    }

    public int peek() {
        fillStack();
        System.out.println(stack2.peek());
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    private void fillStack() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
    }

    public static void main(String[] args) {
        MyStack2Queue myQueue = new MyStack2Queue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.peek();
        myQueue.pop();
        myQueue.peek();
        System.out.println(myQueue.empty());
    }
}
