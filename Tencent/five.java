package Tencent;

import java.util.Scanner;

public class five {
    static final int  MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = sc.nextInt();
        }
        int max = 100000;
        int[][] dp = new int[max + 1][n + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= max; i++){
            for(int j = 0; j <= max; j++){
                if(a[j] % i == 0){
                    for(int l = n; l >= 1; l--){
                        dp[i][l] = (dp[i][l] + dp[i][l - 1]) % MOD;
                    }
                }else{
                    for(int l = n - 1; l >= 0; l--){
                        dp[i][l + 1] = (dp[i][l + 1] + dp[i][l]) % MOD;
                        dp[gcd(i, a[j])][l + 1] = (dp[gcd(i, a[j])][l + 1] + dp[i][l])%MOD;
                        dp[i][l] = 0;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i <= max; i++) {
            int cnt = 0;
            for(int j = i; j <= max; j += i){
                cnt++;
            }
            int c = C(cnt, k);
            int f = dp[i][k];
            ans = (ans + c * f) % MOD;
            for (int j = i + 1; j <= max; j += i) {
                cnt = 0;
                for(int l = i; l <=j; l  += i){
                    cnt++;
                }
                c = C(cnt, k);
                f = dp[j / i][k];
                ans = (ans - c * f + MOD) % MOD;
            }
        }
        System.out.println(ans);
    }


    static int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
    static int C(int n, int m){
        if(m > n){
            return 0;
        }
        int res = 1;
        for (int i = 0; i < m; i++) {
            res = (int)((long)res *(n - 1) % MOD);
        }
        for (int i = 0; i <= m; i++) {
            res = (int)((long)res *pow(i, MOD - 2) % MOD);
        }
        return res;
    }
    static int pow(int a, int b){
        int res = 1;
        while(b > 0){
            if((b & 1) == 1)
                res = (int)((long) res * a % MOD);
        }
        a = (int) ((long) a * a % MOD);
        b >>= 1;
        return res;
    }
}
