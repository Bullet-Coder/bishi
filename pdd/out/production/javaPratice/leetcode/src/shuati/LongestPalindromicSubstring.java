package shuati;
//最长回文子串
public class LongestPalindromicSubstring {
    //动态规划
    public String longestPalindrome1(String s) {
        int len = s.length();
        if (len < 2) return s;

        int maxLen = 1;
        int begin = 0;
        boolean[][] dp = new boolean[len][len];
        for( int i = 0; i < len; i++){
            dp[i][i] = true;
        }

        char[] charArray = s.toCharArray();
        for (int L = 2; L <= len; L++) {
            for (int i = 0; i < len; i++){
                int j = L + i - 1;
                if(j >= len){
                    break;
                }
                if (charArray[i] != charArray[j]){
                    dp[i][j] = false;
                }else{
                    if (j-i<3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i+1][j-1];
                    }
                }

                if(dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
//中心扩展算法
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (s == null || len < 1){
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < len; i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int lens = Math.max(len1, len2);
            if (lens > end - start){
                start = i - (lens - 1) / 2;
                end = i + lens / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    public int expandAroundCenter (String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            --left;
            ++right;
        }
        return right - left - 1;
    }
    int leftMark = 0;
    int lenMax = 0;
    public String longestPalindrome(String s) {
        int len = s.length();
        int start = 0;
        for(int i = 0; i < len; i++){
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return s.substring(leftMark, lenMax);
    }

    public void helper(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            if(right - left + 1 > lenMax){
                leftMark = left;
                lenMax = right - left + 1;
            }
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        String s = "cbbd";
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        //String ans = lps.longestPalindrome1(s);
        String ans = lps.longestPalindrome(s);
        System.out.println(ans);
    }
}
