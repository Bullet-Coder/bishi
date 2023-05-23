package shuati;

import java.util.Arrays;

public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k >= arr.length) return arr;
        return quickSort(arr, k, 0, arr.length - 1);
    }
    public int[] quickSort(int[] arr, int k, int l, int r){
        int i = l, j = r;
        while(i < j){
            while(i < j && arr[j] >= arr[l]) j--;
            while(i < j && arr[i] <= arr[l]) i++;
            swap(arr, i, j);
        }
        swap(arr, i, l);
        if(i > k) return quickSort(arr, k, l, i - 1);
        if(i < k) return quickSort(arr, k, i + 1, r);
        return Arrays.copyOf(arr, k);
    }
    public void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,1,6,2,7,3,8};
        GetLeastNumbers gln = new GetLeastNumbers();
        gln.getLeastNumbers(nums,4);
    }
}
