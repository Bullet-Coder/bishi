package shuati;

import java.util.ArrayList;
import java.util.List;

public class CountSmaller {

    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int len = nums.length;
        int[] temp = new int[len];
        int[] res = new int[len];
        //创建索引数组，方便归并回去的时候是哪个下标的元素
        int[] indexes = new int[len];
        for(int i = 0; i < len; i++){
            indexes[i] = i;
        }
        mergeAndCountSmaller(nums, 0, len - 1, indexes, temp, res);
        //将int[] 转换为list
        for(int i = 0; i < len; i++)
            result.add(res[i]);
        return result;
    }

    public void mergeAndCountSmaller(int[] nums, int left, int right, int[] indexes, int[] temp, int[] res){
        if (left == right) {
            return;
        }
        int mid = left + (right - left) / 2;
        mergeAndCountSmaller(nums, left, mid, indexes, temp, res);
        mergeAndCountSmaller(nums, mid + 1, right, indexes, temp, res);

        // 归并排序的优化，如果索引数组有序，则不存在逆序关系，没有必要合并
        if (nums[indexes[mid]] <= nums[indexes[mid + 1]]) {
            return;
        }
        mergeOfTwoSortedArrAndCountSmaller(nums, left, mid, right, indexes, temp, res);

    }

    //此时[left,mid]和[mid + 1, right]已经排好序
    public void mergeOfTwoSortedArrAndCountSmaller(int[] nums, int left, int mid, int right, int[] indexes, int[] temp, int[] res){
        for(int i = left; i <= right; i++){
            temp[i] = indexes[i];
        }
        int i = left, j = mid + 1;
        for(int k = left; k <= right; k++){
            if(i > mid){
                indexes[k] = temp[j];
                j++;
            }else if(j > right){
                indexes[k] = temp[i];
                i++;
                res[indexes[k]] += right - mid;
            }else if(nums[temp[i]] <= nums[temp[j]]){
                //使用<=，保持稳定性
                indexes[k] = temp[i];
                i++;
                res[indexes[k]] += j - mid - 1;
            }else{
                indexes[k] = temp[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        CountSmaller cs = new CountSmaller();
        cs.countSmaller(nums);
    }
}
