package shuati;

public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int start = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[start]) {
                nums[++start] = nums[i];
            }
        }
        return start + 1;
    }

    public static void main(String[] args) {
        int[] s = new int[]{1,1,2};
        RemoveDuplicates rd = new RemoveDuplicates();
        System.out.println(rd.removeDuplicates(s));
    }
}
