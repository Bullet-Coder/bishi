package xiaohongshu;

import java.util.Arrays;
import java.util.Scanner;

public class three {
    public static void main(String[] args) {
        System.out.println((2e20 - 1) > Integer.MAX_VALUE);

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
        }

        int o = sc.nextInt();
        int[][] bondary = new int[o][2];
        for(int i = 0; i < o; i++){
            bondary[i][0] = sc.nextInt() - 1;
        }
        for(int i = 0; i < o; i++){
            bondary[i][1] = sc.nextInt() - 1;
        }

        String s = sc.next();
        char[] opera = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            opera[i] = s.charAt(i);
        }
        int[] operaNum = new int[o];
        for (int i = 0; i < o; i++) {
            operaNum[i] = sc.nextInt();
        }

        for(int i = 0; i < o; i++){
            int left = bondary[i][0], right = bondary[i][1];
            char ch = opera[i];
            for(int j = left; j <= right; j++){
                if(ch == '='){
                    nums[j] = operaNum[i];
                }else if(ch == '|'){
                    nums[j] |= operaNum[i];
                }else{
                    nums[j] &= operaNum[i];
                }
            }
        }
        for(int i = 0; i < n; i++){
            System.out.printf(nums[i] + " ");
        }
    }
}
