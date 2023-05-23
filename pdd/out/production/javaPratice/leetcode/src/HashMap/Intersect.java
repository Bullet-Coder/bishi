package HashMap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Intersect {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int num1 : nums1){
            map.put(num1, map.getOrDefault(num1, 0) + 1);
        }
        Set<Integer> keys = map.keySet();
        int n = Math.min(nums1.length, nums2.length);
        int[] res = new int[n];
        int i = 0;
        for(int num2 : nums2){
            if(map.getOrDefault(num2, 0) > 0){
                res[i++] = num2;
                map.put(num2, map.get(num2) - 1);
            }
        }
        return Arrays.copyOf(res,i);
    }

    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        Intersect is = new Intersect();
        System.out.println(Arrays.toString(is.intersect(nums1, nums2)));
    }
}
