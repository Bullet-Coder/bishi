package meituan2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        sc.nextLine();
        while(k-- >= 0){
            int n = sc.nextInt();
            int[] in = new int[n];
            int[] out = new int[n];
            Deque<Integer> dq = new ArrayDeque<>();
            for(int i = 0; i < n; i++){
                in[i] = sc.nextInt();
            }
            for(int i = 0; i < n; i++){
                out[i] = sc.nextInt();
            }
            int j = 0;
            for(int i = 0; i < n; i++){
                dq.push(in[i]);
                while(!dq.isEmpty() && out[j] == dq.peek()) {
                    dq.pop();
                    j++;
                }
            }
            if(dq.isEmpty()) System.out.println("Yes");
            else System.out.println("No");
        }
    }

}
