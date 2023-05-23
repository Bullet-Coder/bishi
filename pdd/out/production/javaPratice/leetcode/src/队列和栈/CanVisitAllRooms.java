package 队列和栈;

import java.util.ArrayList;
import java.util.List;
class pp{
    int id, x, v;
}
public class CanVisitAllRooms {
    private int cnt = 0;
    private boolean[] visited;
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        visited = new boolean[n];
        dfs(rooms, 0);
        return cnt == n;
    }

    private void dfs(List<List<Integer>> rooms, int i){
        visited[i] = true;
        cnt++;
        for(int j : rooms.get(i)){
            if(!visited[j]){
                dfs(rooms, j);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer>  ls1 = new ArrayList();
        List<Integer>  ls2 = new ArrayList();
        List<Integer>  ls3 = new ArrayList();
        List<Integer>  ls4 = new ArrayList();

        ls1.add(1);
        ls1.add(3);
        ls2.add(3);
        ls2.add(0);
        ls2.add(1);
        ls3.add(2);
        ls4.add(0);
        List<List<Integer>> ls = new ArrayList<>();
        ls.add(ls1);
        ls.add(ls2);
        ls.add(ls3);
        ls.add(ls4);
        CanVisitAllRooms cav = new CanVisitAllRooms();
        System.out.println(cav.canVisitAllRooms(ls));
    }
}
