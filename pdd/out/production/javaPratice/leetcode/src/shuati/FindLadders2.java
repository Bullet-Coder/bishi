package shuati;
import java.util.*;
public class FindLadders2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        Map<String, Integer> steps = new HashMap<>();
        Set<String> dict = new HashSet<>(wordList);
        Map<String, List<String>> from = new HashMap<>();
        if(!dict.contains(endWord)) return res;
        dict.remove(beginWord);
        //1. 广度优先搜索建图
        //记录扩展出的单词是在第几次扩展的时候得到的
        steps.put(beginWord, 0);
        //记录单词是从哪些词扩展而来
        int step = 1;
        boolean found = false;
        int wordLen = beginWord.length();
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String currentWord = queue.poll();
                char[] charArray = currentWord.toCharArray();
                for(int j = 0; j < wordLen; j++){
                    char originChar = charArray[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        charArray[j] = c;
                        String nextWord = String.valueOf(charArray);
                        if(steps.containsKey(nextWord))
                            if(step == steps.get(nextWord))
                                from.get(nextWord).add(currentWord);
                        if(!dict.contains(nextWord))
                            continue;

                        //如果一个单词扩展出来的单词以前遍历过，距离一定更远，为了避免搜到已经遍历过的且距离更远的单词，将他从dict删除
                        dict.remove(nextWord);
                        queue.offer(nextWord);
                        if(!from.containsKey(nextWord))
                            from.put(nextWord, new ArrayList<>());
                        from.get(nextWord).add(currentWord);
                        steps.put(nextWord,step);
                        if(nextWord.equals(endWord))
                            found = true;
                    }
                    charArray[j] = originChar;
                }
            }
            step++;
            if(found) break;
        }

        //2. 回溯找到所有解，从endWord恢复到beginWord，每次尝试操作path列表的头部
        if(found){
            Deque<String> path = new ArrayDeque<>();
            path.add(endWord);
            backTrack(from, path, beginWord, endWord, res);
        }
        return res;


    }

    public void backTrack(Map<String, List<String>> from, Deque<String> path, String beginWord, String curWord, List<List<String>> res){
        if(curWord.equals(beginWord)){
            res.add(new ArrayList<>(path));
            return;
        }
        for(String precursor : from.get(curWord)){
            path.addFirst(precursor);
            backTrack(from, path, beginWord, precursor, res);
            path.removeFirst();
        }
    }

    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, words);
        FindLadders2 fl = new FindLadders2();
        fl.findLadders(beginWord, endWord, wordList);
    }
}
