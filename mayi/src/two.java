import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class two {
    private static List<Integer>[] adjList;
    private static char[] colors;
    private static int[] reds;
    private static int[] whites;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        colors = sc.nextLine().toCharArray();
        adjList = new ArrayList[n];
        for(int i = 0; i < n; i++){
            adjList[i] = new ArrayList<>();
        }
        for(int i = 0; i < n - 1; i++){
            int u = sc.nextInt() - 1;
        }
    }
}
