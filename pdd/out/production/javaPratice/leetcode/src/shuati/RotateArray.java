package shuati;

import java.util.Arrays;
//翻转数组
//[1,2,3,4,5,6] (k = 2)-> [3,4,5,6,1,2]
public class RotateArray {
    public int[] rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        int count = gcd(k,n);
//        int start = 0;
        for (int start = 0; start < count; ++start) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % n;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
            } while (start != current);
        }return nums;
    }

    public int gcd(int x, int y){
        return y > 0 ? gcd(y, x % y) : x;
    }


    public int[] rotate1(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        return  nums;
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public static void main(String[] args) {
        int [] nums = {-1,-100,3,99};
        int k = 2;
        RotateArray ra = new RotateArray();
        int [] ans = ra.rotate(nums,k);
        int [] ans1 = ra.rotate1(nums,k);
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(ans1));
    }
}
