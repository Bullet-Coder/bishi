package shuati;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SubsetsWithDup {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length == 0){
            res.add(path);
            return res;
        }
        Arrays.sort(nums);
        used = new boolean[nums.length];
        helper(nums, 0);
        return res;
    }

    private void helper(int[] nums, int startIndex){
        res.add(new ArrayList<>(path));
        if(startIndex >= nums.length) return;
        for(int i = startIndex; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            path.add(nums[i]);
            used[i] = true;
            helper(nums, i + 1);
            path.removeLast();
            used[i] = false;
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i = 0; i < nums.length; i++){
            int size = res.size();
            for(int j = 0; j < size; j++){
                List<Integer> newSub = res.get(j);
                newSub.add(nums[i]);
                res.add(newSub);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,8};
        SubsetsWithDup swd = new SubsetsWithDup();
        swd.subsets(nums);
    }
}
