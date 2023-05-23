import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class four {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
        long[] sum = new long[n];
        sum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            sum[i] = sum[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {

            int average = (int)((float) sum[i] / (i + 1) + 0.5);
            System.out.print(Math.round(average) + " ");
        }
        System.out.println();
        Queue<Long> a = new PriorityQueue<>();
        Queue<Long> b = new PriorityQueue<Long>(Collections.reverseOrder());

        for(int i = 0; i < n; i++){
            if(a.size() == b.size()){
                a.add((long) nums[i]);
                b.add(a.poll());
            }else{
                b.add((long) nums[i]);
                a.add(b.poll());
            }
            if(a.size() == 0 && b.size() == 0)break;
            if(a.size() == b.size()){
                System.out.print((int)((a.peek() + b.peek()) / 2.0 + 0.5) + " ");
            }else System.out.print(b.peek() + " ") ;
        }

    }

}
