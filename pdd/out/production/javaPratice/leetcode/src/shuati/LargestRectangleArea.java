package shuati;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int[] tmp = new int[heights.length + 2];
        System.arraycopy(heights, 0, tmp, 1, heights.length);
        Deque<Integer> stack = new ArrayDeque<>();
//        stack.addFirst(0);
//        stack.addFirst(1);
        int maxArea = 0;
        for(int i = 0; i < tmp.length; i++){
            while(!stack.isEmpty() && tmp[i] < tmp[stack.peek()]){
                int h = tmp[stack.pop()];
                int area = (i - stack.peek() - 1) * h;
                maxArea = Math.max(area, maxArea);
            }
            stack.push(i);
        }
        return maxArea;
    }

    //正则表达式匹配
    public boolean isMatch(String s, String p) {
        int sn = s.length(), pn = p.length();
        boolean[][] dp = new boolean[sn + 1][pn + 1];
        dp[0][0] = true;
        for(int j = 2; j < pn; j+=2){
            if(p.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 2];
        }
        for(int i =1; i < sn; i++){
            for(int j = 1; j < pn; j++){
                if(s.charAt(i- 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                    dp[i][j] = dp[i - 1][j - 1];
                else if(p.charAt(j - 1) == '*'){
                    //*号前面一个字符j - 2匹配当前i - 1字符， 三种情况
                    if(s.charAt(i - 1) == p.charAt(j - 2) ||
                            p.charAt(j - 2) == '.')
                        //删除，考察s(0, i); p(0, j -3)
                        //抵消，考察s(0, i - 1); P(0, j - 3)
                        //重复，考察s(0, i - 1); p(0, j - 1),表示前面的” . “可以出现无限多次
                        dp[i][j] = dp[i][j - 2] || dp[i - 1][j - 2] || dp[i - 1][j];
                    else{
                        //*号前面一个字符j - 2 != 当前i - 1字符
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[sn][pn];
    }

    public static void main(String[] args) {

        int[] heights = {2,1,5,6,2,3};
        LargestRectangleArea lra = new LargestRectangleArea();
        lra.largestRectangleArea(heights);
    }
}
