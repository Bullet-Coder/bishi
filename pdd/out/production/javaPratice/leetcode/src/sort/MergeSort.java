package sort;

public class MergeSort {
    static void mergeSort(int[] nums, int l, int r) {
        // 终止条件
        if (l >= r) return;
        // 递归划分
        int m = (l + r) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);
        // 合并子数组
        int[] tmp = new int[r - l + 1]; // 暂存需合并区间元素
        for (int k = l; k <= r; k++)
            tmp[k - l] = nums[k];
        int i = 0, j = m - l + 1;       // 两指针分别指向左/右子数组的首个元素
        for (int k = l; k <= r; k++) {  // 遍历合并左/右子数组
            if (i == m - l + 1)
                nums[k] = tmp[j++];
            else if (j == r - l + 1 || tmp[i] <= tmp[j])
                nums[k] = tmp[i++];
            else {
                nums[k] = tmp[j++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {3,6,2,4};
        mergeSort(nums, 0, nums.length - 1);
    }
    // 调用


}
