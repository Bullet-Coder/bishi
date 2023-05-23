package 队列和栈;

public class FindTargetSumWays {
    private int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        dfs(nums, 0, target, 0);
        return count;
    }

    public void dfs(int[] nums, int index, int target, int current){
        if(index == nums.length){
            if(target == current){
                count++;
            }
            return;
        }
        System.out.println(current);
        dfs(nums, index+1, target, current + nums[index]);
        dfs(nums, index+1, target, current - nums[index]);
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int target = 3;
        FindTargetSumWays fts = new FindTargetSumWays();
        int n = fts.findTargetSumWays(nums, target);
        System.out.println(n);
    }
}
