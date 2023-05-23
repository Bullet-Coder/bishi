package shuati;

public class FindUnsortedSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int min = nums[n - 1];
        int max = nums[0];
        int left = 0, right = 0;
        for(int i = 1; i < n; i++){
            max = Math.max(nums[i], max);
            if(nums[i] < max)
                left = i - 1;
            break;
        }

        for(int i =  n - 2; i >= 0; i--){
            min = Math.min(nums[i], min);
            if(nums[i] > min)
                right = i + 1;
            break;
        }

        return right - left + 1;
    }

    public static void main(String[] args) {
        findUnsortedSubarray(new int[]{2,6,4,8,10,9,15});
    }
}
