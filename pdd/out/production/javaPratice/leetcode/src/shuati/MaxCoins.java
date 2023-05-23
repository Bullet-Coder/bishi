package shuati;

import java.util.Arrays;

public class MaxCoins {
    int[][] rec;
    int[] val;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        val = new int[n + 2];
        for(int i = 1; i <= n; i++){
            val[i] = nums[i - 1];
        }
        val[0] = val[n + 1] = 1;
        rec = new int[n + 2][n + 2];
        for(int i = 0; i <= n + 1; i++){
            Arrays.fill(rec[i], -1);
        }
        addBullon(0, n + 1);
        return 0;
    }
    public int addBullon(int left, int right){
        if(left + 1 >= right) return 0;
        if(rec[left][right] != -1) return rec[left][right];
        for(int i = left + 1; i < right; i++){
            int sum = val[i] * val[left] * val[right];
            sum += addBullon(left, i) + addBullon(i, right);
            rec[left][right] = Math.max(rec[left][right], sum);
        }
        return rec[left][right];
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};
        MaxCoins mc = new MaxCoins();
        mc.maxCoins(nums);
    }
}
