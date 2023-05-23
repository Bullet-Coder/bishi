import java.util.*;
/*
* 小红拿到了一棵树，每个节点被染成了红色或者蓝色。

小红定义每条边的权值为：删除这条边时，形成的两个子树的同色连通块数量之差的绝对值。

小红想知道，所有边的权值之和是多少？
输入描述
第一行输入一个正整数  ,代表节点的数量。
第二哈输入一个长度为  且仅由  和  两种字符组成的字符串。
第 i个字符为 R代表i号节点被染成红色，为B则被染成蓝色。
接下来的n - 1行，每行输入两个正整数u和v，代表节点u和节点v有一条边相连。
4
BBRR
1 2
3 2
4 1

输出描述
一个正整数，代表所有节点的权值之和。
2
* */
public class TreeColor {
    static List<Integer> [] e = new List [200005];
    static String a = new String();
    static long ans = 0;
    static int [] dp = new int [200005];
    public static void dfs (int u , int fa){
        dp[u] = 1;
        for (int v : e[u]){
            if (v == fa) continue;
            dfs(v , u);
            dp[u] += dp[v];
            if (a.charAt(u - 1) == a.charAt(v - 1)) dp[u]--;
        }
    }
    public static void dfs1 (int u , int fa){
        for (int v : e[u]){
            if (v == fa) continue;
            dfs1(v , u);
            int x = dp[1] - dp[v];
            if (a.charAt(u - 1) == a.charAt(v - 1)) {
                x += 1;
            }
            ans += Math.abs(x - dp[v]);
        }
    }
    public static void main (String argc[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0 ; i <= n ; i++)
            e[i] = new ArrayList<>();
        a = sc.nextLine();
        a = sc.nextLine();
        for (int i = 0 ; i < n - 1 ; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            e[x].add(y);
            e[y].add(x);
        }
        dfs(1 , -1);
        dfs1(1 , -1);
        System.out.println(ans);
        return ;
    }
}