package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;

public class FindKthLargest {
    public final static Random random = new Random(System.currentTimeMillis());
    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        int target = len - k;
        int left = 0, right = len - 1;
        while(true){
            int pivotIndex = partition(nums, left, right);
            if(pivotIndex == target) return nums[pivotIndex];
            else if(pivotIndex > target) right = pivotIndex - 1;
            else left = pivotIndex + 1;
        }
    }

    public int partition(int[] nums, int left, int right){
        int randomInt = left + random.nextInt(right - left + 1);
        swap(nums, left, randomInt);
        int i = left, j = right;
        while(i < j){
            while(i < j && nums[j] >= nums[left]) j--;
            while(i < j && nums[i] <= nums[left]) i++;
            swap(nums, i, j);
        }
        swap(nums, i ,left);
        return i;
    }

    public void swap(int[] nums, int left, int right){
        int temp = nums[right];
        nums[right] = nums[left];
        nums[left] = temp;
    }
    public static int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(k);
        for(int i = 0; i < k; i++){
            if(i < k){
                pq.offer(nums[i]);
            }
            else if(nums[i] > pq.peek()){
                pq.poll();
                pq.offer(nums[i]);
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,2,1,5,6,4};
        int[] nums = {1,1,1,2,2,3};
        int k = 3;
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((o1, o2) -> (o1.getValue() - o2.getValue()));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            queue.offer(entry);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        findKthLargest2(a, k);
        FindKthLargest fkl = new FindKthLargest();
        int res = fkl.findKthLargest(a,k);
        System.out.println(res);
    }

}
