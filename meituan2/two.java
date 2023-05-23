package meituan2;



import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }
//        int[] dp = new int[n];
        if(n == 1){
            System.out.println(nums[0]);
        }else if(n == 2){
            System.out.println(Math.max(nums[0], nums[1]));
        }else {
            int max = 0;
            for (int i = 3; i < n; i++) {
                nums[i] = Math.max(nums[i] + nums[i - 3], Math.max(nums[i - 1], nums[i - 2]));
                max = Math.max(max, nums[i]);
            }
            System.out.println(max);
        }
    }
}
