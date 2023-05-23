package lianxi;

import java.util.Arrays;
import java.util.Scanner;

/*
* 给定一个大小为的数组，你需要选择恰好个元素使每个元素分别进行一次如下操作:
* 1 使该元素乘2
* 2 使该元素除以2，向下取整。
* 请注意，对于每个元素只能进行两种操作中的一种，且只能操作一次。
* 你需要使得k次操作后，数组的极差尽可能小。请你求出这个最小的极差。
* 提示:数组的极差指数组的最大值减去最小值
*
* */

/*
思路：将数组数据排序：1 2 3 4 5
前i个*2，后k - i * 2，然后看min（最大-最小）
相当于将数组分为3段，求每段的最大最小，然后比较得出最大最小值
*/
public class KthOpeartion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int []a = new int[n];
            Arrays.sort(a);
            int res = (int) 1e9;
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }
            for (int i = 0; i <= k; i++) {
                int mi = (int)1e9, mx = 0;
                //[0, i-1]段
                if(i > 0){
                    mi = Math.min(mi, a[0] * 2);
                    mx = Math.max(mx, a[i - 1] * 2);
                }
                //[n - (k-i), n-1]段
                if(k - i > 0){
                    mi = Math.min(mi, a[n - (k - i)] / 2);
                    mx = Math.max(mx, a[n - 1] / 2);
                }
                //[i, n-(k-i) -1]段
                if(n != k){
                    mi = Math.min(mi, a[i]);
                    mx = Math.max(mx, a[n-(k-i) -1]);
                }
                res = Math.min(res, mx - mi);
            }
            System.out.println(res);
        }
    }
}
