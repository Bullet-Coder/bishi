package meituan2;
/*
5 5
1 2 2 4 5
1 3 7 9 15

1 1 2 3 3

5 7
1 2118 2145 4141 51891
1 15612 191616 5160568 10561065 19602311919 16503632023
*/

import java.util.*;

public class three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        //n次询问
        int n = sc.nextInt();
        long[] a = new long[k];
        long[] q = new long[n];
        int[] res = new int[n];
        for (int i = 0; i < k; i++) {
            a[i] = sc.nextLong();
            if(i > 0)
                a[i] = a[i - 1] + a[i] * a[i];
        }
        for (int i = 0; i < n; i++) {
            q[i] = sc.nextLong();
        }
//        long[] sum = new long[k];
//        sum[0] = (long) a[0] * a[0];

        for(int i = 0; i < n; i++){
            int num = binaryS(a, q[i]);
            System.out.print(num + " ");
        }
    }

    public static int binaryS(long[] sum, long num){
        int l = 0, r = sum.length - 1;
        while(l <= r){
            int mid = (l + r) /2;
            if(sum[mid] <= num){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return l;
    }
}
