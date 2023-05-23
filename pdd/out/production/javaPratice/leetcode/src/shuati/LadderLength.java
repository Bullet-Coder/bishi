package shuati;


import java.util.*;

public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //创建wordset存放wordlist，并去除初始单词
        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.remove(beginWord);
        //创建visited集合，存放遍历过的单词，并放入初始单词
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);
        //创建队列，存放下一个需要遍历的单词，并放入初始单词
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        //由于初始单词已经遍历，设定step为1
        int step = 1;
        //广度优先遍历
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String currentWord = queue.poll();
                if(changeWordByLetter(currentWord, endWord, queue, visited, wordSet))
                    return step + 1;
            }
            step++;
        }
        return 0;
    }

    public boolean changeWordByLetter(String currentWord, String endWord, Queue<String> queue, Set<String> visited, Set<String> wordSet){
        char[] charArray = currentWord.toCharArray();
        for(int i = 0; i < currentWord.length(); i++){
            char originChar = charArray[i];
            for(char k = 'a'; k <= 'z'; k++){
                if(k == originChar) continue;
                charArray[i] = k;
                String nextWord = String.valueOf(charArray);
                if(wordSet.contains(nextWord)){
                    if(nextWord.equals(endWord)) return true;
                    if(!visited.contains(nextWord)){
                        queue.offer(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            charArray[i] = originChar;
        }
        return false;
    }

    public static void main(String[] args) {
        LadderLength ll = new LadderLength();
        String[] word = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = Arrays.asList(word);
        ll.ladderLength("hit", "cog", wordList);
    }
}
