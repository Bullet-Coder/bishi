package lianxi;

import java.util.Scanner;


/*给定一棵二叉树，试求这棵二叉树有多少个节点满足以该节点为根的子树是满二叉树?
我们定义一棵树是满二叉树，当且仅当每一层的节点数量都达到了最大值(即无法在这一层添加新节点)。
第一行输入一个正整数n，代表节点的数量。接下来的n行，第i行输入两个整数l和r，代表i号节点的左儿子和右儿子。
请注意，如果一个节点没有左儿子/右儿子，则对应的l/r为-1
输入：
5
2 3
4 5
-1 -1
-1 -1
-1 -1
输出：
4
*/
public class one {
    static final int maxn = 2 * (int)1e5 + 5;
    static int[][] e = new int[maxn][2];
    static int[] d = new int[maxn];
    static int[] dp = new int[maxn];
    static void dfs(int u) {
        // l , r为左右儿子节点
        int l = e[u][0];
        int r = e[u][1];
        // 转移case 1,也是边界条件
        if (l == -1 && r == -1) {
            dp[u] = 1;
            return;
        }
        if (l != -1)
            dfs(l);
        if (r != -1)
            dfs(r);
        // 转移case 2
        if (l != -1 && r != -1 && dp[l] == dp[r] && dp[l] != 0)
            dp[u] = dp[l] + 1;
            // 转移case 3
        else
            dp[u] = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // 读入图
        for (int i = 1; i <= n; i++) {
            e[i][0] = sc.nextInt();
            e[i][1] = sc.nextInt();
            // d用来记录度数
            if (e[i][0] != -1)
                d[e[i][0]]++;
            if (e[i][1] != -1)
                d[e[i][1]]++;
        }
        // 寻找根
        int rt = -1;
        for (int i = 1; i <= n; i++)
            if (d[i] == 0)
                rt = i;
        // 从根开始dfs
        dfs(rt);
        // 求答案
        int ans = 0;
        for (int i = 1; i <= n; i++)
            ans += dp[i] != 0 ? 1 : 0;
        System.out.println(ans);
    }
}
