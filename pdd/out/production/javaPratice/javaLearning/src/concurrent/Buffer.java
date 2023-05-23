package concurrent;

public class Buffer {
    private int data;
    private boolean empty;

    public synchronized int get() {
        while (empty) {
            try {
                wait(); // 等待缓冲区非空
            } catch (InterruptedException e) {}
        }
        empty = true;
        notifyAll(); // 通知生产者可以写入数据
        return data;
    }

    public synchronized void put(int data) {
        while (!empty) {
            try {
                wait(); // 等待缓冲区为空
            } catch (InterruptedException e) {}
        }
        empty = false;
        this.data = data;
        notify(); // 通知消费者可以读取数据
    }

    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        // 创建生产者线程
        Thread producerThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                buffer.put(i); // 向缓冲区中写入数据
                System.out.println("生产者写入数据：" + i);
            }
        }, "生产者");

        // 创建消费者线程
        Thread consumerThread = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                int data = buffer.get(); // 从缓冲区中读取数据
                System.out.println("消费者读取数据：" + data);
            }
        }, "消费者");

        // 启动生产者和消费者线程
        producerThread.start();
        consumerThread.start();

        // 等待两个线程执行完毕
        try {
            producerThread.join();
            consumerThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
