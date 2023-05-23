package shuati;

public class CoinChange {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0) return -1;
        memo = new int[amount];
        return findWay(coins, amount);

    }
    public int coinChange2(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        memo[0] = 0;
        for(int i = 1; i <= amount; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0 && memo[i - coins[j]] < min)
                    min = memo[i - coins[j]] + 1;
            }
            memo[i] = min;
        }
        return memo[amount] == Integer.MAX_VALUE ? -1 : memo[amount];

    }

    public int findWay(int[] coins, int amount){
        if(amount < 0) return -1;
        if(amount == 0) return 0;
        if(memo[amount - 1] != 0) return memo[amount - 1];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            int res = findWay(coins, amount - coins[i]);
            if(res >= 0 && res < min) min = res + 1;
        }
        memo[amount - 1] = (min == Integer.MAX_VALUE ? -1 : min);
        return memo[amount - 1];
    }

    public static void main(String[] args) {
        int[] coins = {1,3,5};
        int amount = 11;
        CoinChange cc = new CoinChange();
        cc.coinChange2(coins, amount);
    }
}
