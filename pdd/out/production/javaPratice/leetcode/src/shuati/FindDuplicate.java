package shuati;

public class FindDuplicate {
    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        slow = nums[slow];
        fast = nums[nums[fast]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int pre1 = 0, pre2 = slow;
        System.out.println("pre1: " + pre1 + "  " + "pre2: " + pre2);
        while(pre1 != pre2){
            pre1 = nums[pre1];
            pre2 = nums[pre2];
            System.out.println("pre1: " + pre1 + "  " + "pre2: " + pre2);
        }
        System.out.println("========================");
        return pre1;
    }

    public static int findDuplicate1(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        System.out.println("slow: " + slow +  "  " +  "fast: " + fast);
        while(fast != slow){
            slow = nums[slow];
            fast = nums[fast];
            System.out.println("slow: " + slow +  "  " +  "fast: " + fast);
        }
        System.out.println("========================");
        return fast;
    }

    public static int findDuplicate2(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }
        fast = nums[0];
        System.out.println("slow: " + slow +  "  " +   "fast: " + fast);
        while(fast != slow){
            slow = nums[slow];
            fast = nums[fast];
            System.out.println("slow: " + slow +  "  " +   "fast: " + fast);
        }
        System.out.println("========================");
        return fast;
    }

    public static void main(String[] args) {
        findDuplicate(new int[]{1,3,4,2,2});
        findDuplicate1(new int[]{1,3,4,2,2});
        findDuplicate2(new int[]{1,3,4,2,2});

    }
}
