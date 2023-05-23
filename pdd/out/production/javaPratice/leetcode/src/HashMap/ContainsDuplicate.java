package HashMap;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
//            System.out.println(set.add(num));
            if(!set.add(num)) {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4};
        ContainsDuplicate cd = new ContainsDuplicate();
        System.out.println(cd.containsDuplicate(nums));
        System.out.println(114/10);
    }
}
