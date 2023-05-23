package shuati;

import java.util.*;

public class WordBreak {
    List<String> res = new ArrayList<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        dfs(s, wordDict, 0, new ArrayList<>());
        return res;
    }

    public void dfs(String s, List<String> wordDict, int index, List<String> path){
        if(index == s.length()){
            res.add(new String(String.join(" ", path)));
            return;
        }
        for(int i = index; i <= s.length(); i++){
            if(wordDict.contains(s.substring(index, i))){
                path.add(s.substring(index, i));
                dfs(s, wordDict, i, path);
                path.remove(path.size() - 1);
            }
        }
    }
    public static boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int i = 1; i <= n; i++){
            for(int j = 0; j < i; j++) {
                if (set.contains(s.substring(j, i)) && !dp[i]) {
                    dp[i] = dp[j];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s1 = "pineapplepenapple";
        String s2 = "catsandog";
        String[] word1 = {"apple","pen","applepen","pine","pineapple"};
        String[] word2 = {"cats","dog","sand","and","cat"};
        String[] word3 = {"aaaa","aaa"};

        List<String> wordDict1 = Arrays.asList(word1);
        List<String> wordDict2 = Arrays.asList(word2);
        List<String> wordDict3 = Arrays.asList(word3);
        wordBreak2("aaaaaaa", wordDict3);
        WordBreak wb = new WordBreak();
        wb.wordBreak(s1, wordDict1);
        wb.wordBreak(s2, wordDict2);
        float f = 45.0F;
        HashMap<Integer, Integer> map = new HashMap<>();

    }
}
