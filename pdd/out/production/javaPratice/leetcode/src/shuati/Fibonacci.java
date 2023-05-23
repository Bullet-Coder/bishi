package shuati;

public class Fibonacci {
    int fibonacci1(int n, int[] dp) {
        if (n == 0) return 0;           // 返回 f(0)
        if (n == 1) return 1;           // 返回 f(1)
        if (dp[n] != 0) return dp[n];   // 若 f(n) 以前已经计算过，则直接返回记录的解
        dp[n] = fibonacci1(n - 1, dp) + fibonacci1(n - 2, dp); // 将 f(n) 则记录至 dp
        return dp[n];
    }

    int fibonacci2(int n) {
        if (n == 0) return 0;           // 若求 f(0) 则直接返回 0
        int a = 1, b = 1, sum = 0;               // 初始化 f(0), f(1)
        for (int i = 0; i < n; i++) {  // 状态转移求取 f(2), f(3), ..., f(n)
            sum = a + b;
            a = b;
            b = sum;
            System.out.println(b);
        }
        return a;                       // 返回 f(n)
    }


    // 求第 n 个斐波那契数
    int fibonacciMemorized(int n) {
        int[] dp = new int[n + 1]; // 用于保存 f(0) 至 f(n) 问题的解
        return fibonacci1(n, dp);
    }

    public static void main(String[] args) {
        int n = 5;
        Fibonacci f = new Fibonacci();
//        int i = f.fibonacciMemorized(n);
        int res = f.fibonacci2(n);
    }

}
