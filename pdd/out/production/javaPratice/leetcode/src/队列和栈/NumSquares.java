package 队列和栈;
//给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
//完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class NumSquares {
    public int numSquares(int n) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited.add(0);
        int level = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            level++;
            for (int i = 0; i < size; i++){
                int digit = queue.poll();
                for(int j = 1; j <= n; j++){
                    int nodeValue = digit + j * j;
                    if(nodeValue == n) return level;
                    if(nodeValue > n) break;
                    if(!visited.contains(nodeValue)){
                        queue.offer(nodeValue);
                        visited.add(nodeValue);
                    }
                }
            }
        }
        return level;
    }

    public static void main(String[] args) {
        int n = 12;
        NumSquares ns = new NumSquares();
        System.out.println(ns.numSquares(n));
    }
}
