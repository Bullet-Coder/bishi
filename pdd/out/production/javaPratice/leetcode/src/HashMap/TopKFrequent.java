package HashMap;

import java.util.*;

//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
//        输入: nums = [1,1,1,2,2,3], k = 2
//        输出: [1,2]
//
//        输入: nums = [1], k = 1
//        输出: [1]
public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Set<Integer> keys = map.keySet();
        int idx = 0;
        int[] values = new int[keys.size()];
        for(Integer key : keys){
            values[idx] = map.get(key);
            idx++;
        }
        Arrays.sort(values);
        ArrayList<Integer> newValues = new ArrayList<>();
        int count = k;
        for(int i = values.length - 1; i >= 0; i--){
            if(count>0){
                newValues.add(values[i]);
                count--;
            }
        }
        int i = 0;
        for(Integer key : keys){
            if(newValues.contains(map.get(key))){
                res[i++] = key;
            }
        }
        return res;
    }

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,3,3,4,4};
        int k = 2;
        TopKFrequent tk = new TopKFrequent();
        int[] res = tk.topKFrequent1(nums, k);
    }
}
