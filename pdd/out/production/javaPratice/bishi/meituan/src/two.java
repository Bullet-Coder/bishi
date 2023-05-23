import java.util.Scanner;
/*小团在一个n*m的网格地图上探索。网格地图上第i行第j列的格子用坐标（ij）简记。初始时，小团的位置在地图的左上角，即坐标（1，1）。
地图上的每一个格子上都有一定的金币，特别地，小团位于的初始位置（1，1）上的金币为0。小团在进行探索移动时，可以选择向右移动一格（即从（x，y）
到达（x，y+1））或向下移动一格（即从（x，y）到达（x+1，y））。地图上的每个格子都有一个颜色，红色或蓝色。如果小团一次移动前后
的两个格子颜色不同，那么他需要支付k个金币才能够完成这一次移动；如果移动前后的两个格子颜色相同，则不需要支付金币。小团可以在任意
格子选择结束探索。现在给你网格地图上每个格子的颜色与金币数量，假设小团初始时的金币数量为0，请你帮助小团计算出最优规划，使他能获
得最多的金币，输出能获得的最多金币数量即可。
注意：要求保证小团任意时刻金币数量不小于零。

第一行是三个用空格隔开的整数n、m和k，表示网格地图的行数为n，列数为m，在不同颜色的两个格子间移动需要支付k个金币。
接下来n行，每行是一个长度为m的字符串，字符串仅包含字符'R'或'B'。第i行字符串的第j个字符表示地图上第i行第j列的格子颜色，如果字符为'R'则
表示格子颜色为红色，为'B'表示格子颜色为蓝色。
接下来是一个n行m列的非负整数矩阵，第i行第j列的数字表示地图上第i行第j列的格子上的金币数量。保证所有数据中数字大小都是介于[0，10]的整数。
1<=n，m<=200，1<=k<=5。
输出描述
一行一个整数，表示小团能获得的最多金币数量。
1 7 2
BBRBRBR
0 3 2 4 1 1 1

5
*/
import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();
        char[][] color = new char[n][m];
        int[][] value = new int[n][m];
        for (int i = 0; i < n; i++) {
            color[i] = sc.next().toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                value[i][j] = sc.nextInt();
            }
        }
        int[][] dp = new int[n][m];
        dp[0][0] = 0;
        int res = 0;
//        for (int i = 1; i < m; i++) {
//            dp[0][i] = dp[0][i - 1] + (color[0][i] == color[0][i - 1] ? 0 : -k) + value[0][i];
//            res = Math.max(dp[0][i], res);
//        }
//        for (int i = 1; i < n; i++) {
//            dp[i][0] = dp[i - 1][0] + (color[i][0] == color[i - 1][0] ? 0 : -k)+ value[i][0];
//            res = Math.max(dp[i][0], res);
//        }
//        for (int i = 1; i < n; i++) {
//            for (int j = 1; j < m; j++) {
//                int right = dp[i][j - 1] + (color[i][j] == color[i][j - 1] ? 0 : -k) + value[i][j];
//                int down = dp[i - 1][j] + (color[i][j] == color[i - 1][j] ? 0 : -k) + value[i][j];
//                dp[i][j] = Math.max(right, down);
//                res = Math.max(res, dp[i][j]);
//
//            }
//        }
//        System.out.println(res);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i != 0 ||  j != 0 )
                    dp[i][j] = -1;
                else continue;
                if(i > 0 && dp[i-1][j] >= 0){
                    if(color[i-1][j] == color[i][j]) dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + value[i][j]);
                    else if(dp[i-1][j] >= k) dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + value[i][j] - k);
                }

                // dp[i][j] = -1;
                if(j > 0 && dp[i][j-1] >= 0){
                    if(color[i][j-1] == color[i][j]) dp[i][j] = Math.max(dp[i][j], dp[i][j-1] + value[i][j]);
                    else if(dp[i][j-1] >= k) dp[i][j] = Math.max(dp[i][j], dp[i][j-1] + value[i][j] - k);

                }
                res = Math.max(res, dp[i][j]);
            }
        }
        System.out.println(res);
    }
}

