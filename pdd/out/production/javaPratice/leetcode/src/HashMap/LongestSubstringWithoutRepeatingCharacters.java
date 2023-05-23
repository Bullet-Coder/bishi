package HashMap;

//无重复字符的最长子串

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int slow = 0;
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                slow = Math.max(slow, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i-slow+1);
        }
        return max;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int n1sat = 0, n2sat = 0;
        int len = m + n;
        int slow = 0, fast = 0;
        for(int i = 0; i <= len / 2; i++){
            slow = fast;
            if(n1sat < m && n2sat >= n || nums1[n1sat] < nums2[n2sat]){
                fast = nums1[n1sat++];
            }else fast = nums2[n2sat++];
        }
        if(len % 2 == 0) return (slow + fast) / 2.0;
        else return fast;
    }

    public static void main(String[] args) {
        String s = "abcabcde";
        Integer[] arr = {3,2,4,1,-3,-4,5,7};
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(Arrays.asList(1,2,3)));
//        Arrays.sort(arr , (a,b) -> b-a);
        Arrays.sort(arr, Comparator.comparingInt(a -> a));
        LongestSubstringWithoutRepeatingCharacters lswrc = new LongestSubstringWithoutRepeatingCharacters();
        double ans = lswrc.findMedianSortedArrays(new int[]{1,2}, new int[]{3,4});
        System.out.println(ans);
    }
}
