package heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(/*new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        }*/);
        PriorityQueue<Integer> queue1 = new PriorityQueue<>(k);
        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i]=queue.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] a = new int[7];
        a = new int[]{3, 2, 1, 4, 5, 7, 6,9};
        int k = 3;
        GetLeastNumbers gln = new GetLeastNumbers();
        int[] res = gln.getLeastNumbers(a, k);
        System.out.println(Arrays.toString(res));
    }

}
