package shuati;

import java.util.Arrays;
//移动0，把0移到最后
public class MoveZeroes {
    public int [] moveZeroes(int[] nums) {
//        int n = nums.length, left = 0, right = 0;
//        while (right < n){
//            if(nums[right] != 0){
//                swap(nums,left, right);
//                left++;
//            }
//            right++;
//        }
//        return nums;
        int n = nums.length , slow = 0, quick = 0;
        for(; quick < n; quick++){
            if(nums[quick] != 0){
                nums[slow++] = nums[quick];
            }
        }
        for(; slow < n; slow++){
            nums[slow] = 0;
        }
        return nums;
    }

//    public void swap(int[] nums, int left, int right){
//        int temp;
//        temp = nums[left];
//        nums[left] = nums[right];
//        nums[right] = temp;
//    }

    public static void main(String[] args) {
        MoveZeroes mz = new MoveZeroes();
        int [] num = {-3, -1, 0, 0,0,4, 9};
        int [] ans = mz.moveZeroes(num);
        System.out.println(Arrays.toString(ans));
    }
}
