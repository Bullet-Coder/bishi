package Tencent;

import java.util.Scanner;

public class four {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            int xor = 0, prod = 1;
            for(int j = i; j < n; j++){
                xor ^= nums[j];
                prod *= nums[j];
                if(xor == prod){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
