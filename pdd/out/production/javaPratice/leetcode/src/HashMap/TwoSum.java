package HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//两数之和哈希表
public class TwoSum {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashtable = new HashMap<Integer, Integer>();
        for (int i = 0;i < nums.length; ++i){
            if (hashtable.containsKey(target-nums[i])) {
                return new int[] {hashtable.get(target - nums[i]), i};
            }
            hashtable.put(nums[i], i);
        }
        return new int[0];
    }

    public static void main(String[] args) {
        int[] num = {1,3,5,7,9};
        int target = 6;
        TwoSum twosum = new TwoSum();
        int[] ans = twosum.twoSum(num, target);
        System.out.println(Arrays.toString(ans));
    }
}
