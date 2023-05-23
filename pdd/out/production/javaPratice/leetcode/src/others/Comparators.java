package others;

import java.util.Comparator;
import java.util.PriorityQueue;

//比较器？lambda表达式？
public class Comparators {
    static class MyComp implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2){
            return o1-o2;
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(new MyComp());
        queue.offer(9);
        queue.offer(5);
        queue.offer(2);
        queue.offer(0);
        queue.offer(3);
        queue.offer(4);
        queue.offer(7);
        queue.offer(1);

        while (!queue.isEmpty()){
            Integer cur = queue.poll();
            System.out.println(cur + "");
        }

    }
}
