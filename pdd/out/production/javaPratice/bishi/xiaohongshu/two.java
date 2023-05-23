package xiaohongshu;

import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int count = kSort(arr, k);
            System.out.println(count);
        }
    }

    private static  int kSort(int[] arr, int k){
        int n = arr.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] == i + 1) continue;;
            int j = i;
            while(j < n && j - i < k){
                if(arr[j] == i + 1) break;
                j++;
            }
            for(int x = j; x > i; x--){
                swap(arr, x, x - 1);
            }
            count++;
        }
        return count;
    }
    private static  void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
