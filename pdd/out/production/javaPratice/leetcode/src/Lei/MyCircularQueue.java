package Lei;

public class MyCircularQueue {
    private int[] data;
    private int front, tail;

    public MyCircularQueue(int k) {
        data = new int[k + 1];
        front = 0;
        tail = 0;
    }

    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }else{
            data[tail] = value;
            tail = (tail + 1) % data.length;
            return true;
        }
    }

    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }else{
            front = (front + 1) % data.length;
            return true;
        }
    }

    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return data[front];
    }

    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        return data[(tail - 1 + data.length) % data.length];
    }

    public boolean isEmpty() {
        return front == tail;
    }

    public boolean isFull() {
        return(tail + 1) % data.length == front;
    }

    public static void main(String[] args) {
        MyCircularQueue queen = new MyCircularQueue(5);
        queen.enQueue(1);
        queen.enQueue(2);
        queen.enQueue(3);
        queen.enQueue(4);
        queen.enQueue(5);
    }
}
