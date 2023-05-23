import java.util.*;

/*
小美是一位天文爱好者，她收集了接下来一段时间中所有会划过她所在的观测地上空的流星信息。具体地，
她收集了n个流星在她所在观测地上空的出现时刻和消失时刻。对于一个流星，若其的出现时刻为s，消失
时刻为t，那么小美在时间段[s，t]都能够观测到它。对于一个时刻，观测地上空出现的流星数量越多，
则小美认为该时刻越好。小美希望能够选择一个最佳的时刻进行观测和摄影，使她能观测到最多数量的流
星。现在小美想知道，在这个最佳时刻，她最多能观测到多少个流星以及一共有多少个最佳时刻可供她选
择。

第一行是一个正整数n，表示流星的数量。第二行是n个用空格隔开的正整数，第i个数si表示第i个流星的出现时间。
第三行是n个用空格隔开的正整数，第i个数ti表示第i个流星的消失时间。
1<=n<=100000,1<=si<=ti<=10^9
输出描述
输出一行用空格隔开的两个数x和Y，其中X表示小美能观测到的最多流星数，y表示可供她选择的最佳时刻数量。
样例输入
3
2 1 5
6 3 7
输出：
2 4
*/

public class three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nums = new int[n][2];
        int max = 0;
        for (int i = 0; i < n; i++) {
            nums[i][0] = sc.nextInt();
            max = Math.max(nums[i][0], max);
        }
        for (int i = 0; i < n; i++) {
            nums[i][1] = sc.nextInt();
            max = Math.max(nums[i][1], max);
        }
        System.out.println(max);
        int[] count = new int[max + 1];
        int maxCount = 0;
        for(int[] num : nums){
            int x = num[0];
            int y = num[1];
            while(x <= y){
                count[x]++;
                maxCount = Math.max(count[x], maxCount);
                x++;
            }
        }
        int res = 0;
        for (int i = 0; i <= max; i++) {
            if(count[i] == maxCount)
                res++;
        }
        System.out.println(maxCount + " " + res);
    }
}
