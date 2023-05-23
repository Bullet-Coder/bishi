package shuati;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReconstructQueue {
    public static int[][] reconstructQueue(int[][] people) {
        //将people按照以身高降序排序，当身高相等，属性升序排序
//        Arrays.sort(people, new Comparator<int[]>(){
//            public int compare(int[] p1, int[] p2){
//                if(p1[0] != p2[0]){
//                    return p2[0] - p1[0];
//                }else return p1[1] - p2[1];
//            }
//        });
        Arrays.sort(people, (a, b) -> (a[0] != b[0] ? b[0] - a[0] : a[1] - b[1]));
        List<int[]> res = new ArrayList<>();
        //根据属性的值在列表中插入元素，因为属性的值表示前方有几个大于它的值，因此正好是它应该在的位置
        for(int[] person : people){
            res.add(person[1], person);
        }
        res.toArray();
        return res.toArray(new int[2][]);
    }

    public static void main(String[] args) {
        reconstructQueue(new int[][]{{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}});
        Integer[] array = new Integer[]{1, 2, 3,0};
        Arrays.sort(array);
        List<Integer> list = new ArrayList<>(Arrays.asList(array));
        list.add(5);
        System.out.println(list);
    }
}
