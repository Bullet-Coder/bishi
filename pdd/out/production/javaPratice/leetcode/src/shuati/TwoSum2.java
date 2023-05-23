package shuati;
//两数之和双指针
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, h = numbers.length - 1;
        while(l < h){
            int sum = numbers[l] + numbers[h];
            if (sum == target){
                return new int[] {l+1, h+1};
            }else if(sum < target){
                ++l;
            }else{
                --h;
            }
        }
        return new int[] {-1,-1};
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int t = 7;
        TwoSum2 twosum2 = new TwoSum2();
        int[] ans = twosum2.twoSum(nums,t);
    }
}
