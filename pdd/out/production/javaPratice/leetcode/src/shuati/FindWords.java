package shuati;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindWords {
    Set<String> set = new HashSet<>();
    List<String> res = new ArrayList<>();
    boolean[][] visited = new boolean[15][15];
    int m, n;
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public List<String> findWords(char[][] board, String[] words) {
        this.m = board.length;
        this.n = board[0].length;
        for(String word : words)
            set.add(word);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                sb.append(board[i][j]);
                visited[i][j] = true;
                dfs(board, i, j, sb);
                visited[i][j] = false;
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, StringBuilder sb){
        if(sb.length() > 10) return;
        if(set.contains(sb.toString())) {
            res.add(sb.toString());
            set.remove(sb.toString());
        }
        for(int k = 0; k < 4; k++){
            int x = i + dx[k];
            int y = j + dy[k];
            if(x < 0 || x >= board.length || y < 0 || y >= board[0].length) continue;
            if(visited[x][y] ) continue;
            visited[x][y] = true;
            sb.append(board[x][y]);
            dfs(board, x, y, sb);
            visited[x][y] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
        String[] words = {"oath","pea","eat","rain"};
        FindWords fw = new FindWords();
        fw.findWords(board, words);
    }
}
