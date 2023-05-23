package XieCheng;

import java.util.Arrays;
import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        int x = n - k + 1, y = 1, k1 = 0;
        for (int i = 0; i < n; i++) {
            if(k1 < k && i % 2 == 0) {
                System.out.print(x++ + " ");;
                k1++;
            }
            else
                System.out.print(y++ + " ");;
        }
    }
}
