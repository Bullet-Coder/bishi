package Lei;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    Map<Character, Trie> next;
    boolean isEnd;
    public Trie() {
        this.next = new HashMap<>();
        this.isEnd = false;
    }

    public void insert(String word) {
        Trie cur = new Trie();
        for(char c : word.toCharArray()){
            if(cur.next.get(c) == null){
                cur.next.put(c, new Trie());
            }
            cur = cur.next.get(c); //向下考察
        }
        cur.isEnd = true;
    }

    public boolean search(String word) {
        Trie end = searchPreFix(word);
        return end != null && end.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPreFix(prefix) != null;
    }

    private Trie searchPreFix(String prefix){
        Trie cur = this;
        for(char c : prefix.toCharArray()){
            if(cur.next.get(c) == null){
                return null; //无此前缀，返回null
            }
            cur = cur.next.get(c);
        }
        return cur;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.search("apple");   // 返回 True
        trie.search("app");     // 返回 False
        trie.startsWith("app"); // 返回 True
        trie.insert("app");
        trie.search("app");     // 返回 True
    }
}
