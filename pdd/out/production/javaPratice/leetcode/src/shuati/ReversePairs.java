package shuati;

public class ReversePairs {
    int res = 0;
    int[] temp;
    public void reversePairs(int[] nums) {
        this.temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1);

    }

    public void mergeSort(int[] nums, int l, int r){
        if(l >= r) return;
        int m = (l + r) / 2;
        mergeSort(nums, l, m);
        mergeSort(nums, m + 1, r);

        for(int i = l; i <= r; i++){
            temp[i] = nums[i];
        }
        int i = l, j = m + 1;
        for(int k = l; k <= r; k++){
            if(i == m + 1){
                nums[k] = temp[j++];
            }else if(j == r + 1 || temp[i] <= temp[j]){
                nums[k] = temp[i++];
            }else{
                nums[k] = temp[j++];
                res += m - i + 1;
            }
        }
    }

    public static void main(String[] args) {
        ReversePairs rp = new ReversePairs();
        rp.reversePairs(new int[]{7,5,6,4});
    }
}
