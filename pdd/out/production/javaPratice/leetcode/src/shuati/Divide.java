package shuati;

import java.util.Random;

public class Divide {
    private final static Random random = new Random(System.currentTimeMillis());
    public static int divide(int dividend, int divisor) {
        boolean negative = (divisor ^ dividend) < 0;
        if(dividend > 0) dividend = -dividend;
        if(divisor > 0) divisor = - divisor;
        int mod = divisor;
        int minn = dividend >> 1;
        int now = -1;
        while(mod >= minn && mod >=(Integer.MIN_VALUE >> 1)){
            mod <<= 1;
            now <<= 1;
        }
        int ans = 0;
        while(dividend <= divisor){
            while(mod < dividend){
                mod >>= 1;
                now >>= 1;
            }
            while(dividend <= mod){
                dividend -= mod;
                ans -= now;
            }
        }
        if(ans == Integer.MIN_VALUE && !negative) return Integer.MAX_VALUE;
        return negative ? -ans : ans;
    }

    public static void main(String[] args) {
        int x = 1;
        System.out.println( ~ 1);
        divide(3000, 45);
    }
}
