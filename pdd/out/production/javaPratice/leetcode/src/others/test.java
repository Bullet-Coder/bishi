package others;

import java.util.*;

public class test {
     int[] so= {1,2,3,4,5,};

    public static void main(String[] args) {
        double v = 0.2 + 0.1;
        System.out.println(v);
        Integer[] a = {1,2,3,4,5,6,7,8};
        int[] b = {1,2,3,4,5,6,7,8};
        int[][] arrs = {{1, 3},{8,10},{2,6},{15,18}};
        Arrays.sort(arrs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        for(int [] arr : arrs){
            System.out.println(Arrays.toString(arr));
        }
        Deque<Integer> deque = new ArrayDeque<>();
        //测试list的addAll方法
        ArrayList<Integer> list = new ArrayList<>(a.length);
        Collections.addAll(list,a);

        //测试list添加了另一个list之后，改变被添加的list的值，新的list会不会改变
        List<Integer> list1 = new LinkedList<>();
        list1.add(10);
        list.addAll(list1);
        list1.add(32);
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>(deque));
        list.toString();
        //测试list的remove
        Set<Integer> set = new HashSet<>(list);
        //测试Arrays.copyOf函数
        int[] c  = Arrays.copyOf(b,5);
        System.out.println(Arrays.toString(c));
        //测试stream流输出
        list.add(5, 5);
        list.stream().forEach(System.out::println);
        //测试getclass方法
        System.out.println(test.class.getName());

        Integer[] string = {1,2};
        int i = string[0].intValue();
        System.out.println(i);
        Queue<Integer> queue =new LinkedList<>();
        String s = " hello world  ";
        System.out.println("s.strip():" + s.strip());
        System.out.println("s.trim():" + s.trim());
        //哈希
        Map<Character, Integer> need = new HashMap<>();
        Map<String, List<String>> map = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(2);

    }
}
