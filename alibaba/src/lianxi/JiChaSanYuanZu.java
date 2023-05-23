package lianxi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
给定一个数组，请你计算有多少个三元组(a,b,c)满足：
max(a,b,c) -min(a,b,c) =1
*/
public class JiChaSanYuanZu {
    //设置输入

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        //如果map不为空
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            //取出map中的数据
            int key = entry.getKey();
            int value = entry.getValue();
            if(map.get((key - 1)) == null) continue;
            res += value * (value - 1) / 2 * map.get(key - 1);
            int value1 = map.get(key - 1);
            res += value1 * (value1 - 1) / 2 * value;
            //判断该数据前一位后一位是否有值，都没有则删除这个数
            //如果该数据-1存在于map中，计算可以组成的数据数量
            //如果该数据 +1存在于map中，计算
        }
        System.out.println(res);
    }
}
