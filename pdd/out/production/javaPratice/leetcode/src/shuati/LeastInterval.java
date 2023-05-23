package shuati;

import java.util.*;
import java.util.stream.Collectors;

public class LeastInterval {

    public static int leastInterval(char[] tasks, int n) {



        int ans=0;
        int time=0;

        return ans+1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        Set<Integer> set1 = Arrays.stream(arr).boxed().collect(Collectors.toCollection(HashSet::new));
        Set<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(4);
        set2.add(3);
        set2.add(5);
        System.out.println(set1.equals(set2));
    }
}
