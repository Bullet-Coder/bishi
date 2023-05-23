package shuati;

public class MaxCakePrice {
    // 输入蛋糕价格列表 priceList ，求重量为 n 蛋糕的最高售价
    int maxCakePrice(int n, int[] priceList, int[] dp) {
        if (n <= 1) return priceList[n]; // 蛋糕重量 <= 1 时直接返回
        int f_n = 0;
        for (int i = 0; i < n; i++) {    // 从 n 种组合种选择最高售价的组合作为 f(n)
            int f_i = dp[i] != 0 ? dp[i] : maxCakePrice(i, priceList, dp);
            f_n = Math.max(f_n, f_i + priceList[n - i]);
        }
        dp[n] = f_n;                     // 记录 f(n) 至 dp 数组
        return f_n;                      // 返回 f(n)
    }

    int maxCakePriceMemorized(int n, int[] priceList) {
        int[] dp = new int[n + 1];
        return maxCakePrice(n, priceList, dp);
    }

    public static void main(String[] args) {
        MaxCakePrice mcp = new MaxCakePrice();
        int n = 1;
        int[] dp = new int[n+1];
        
        dp[0] = 0;dp[1] = 1;
        int[] priceList = {0,2,3,6,7,11,15};
        int res = mcp.maxCakePriceMemorized(n,priceList);
        System.out.println(res);
    }
}
