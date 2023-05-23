package Lei;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class AddPushPop {
    public static void main(String[] args) {
        Deque<Integer> a = new LinkedList<>();
        a.push(1);
        a.add(2);
        a.push(3);
        a.addFirst(3);
        a.add(4);
        a.poll();
        a.pop();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.offer(2);
        queue.offer(3);
        queue.remove();
        queue.poll();
    }
}
