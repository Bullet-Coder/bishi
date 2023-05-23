package HashMap;

import java.util.*;

public class FindRestaurant {
    public String[] findRestaurant(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> res = new HashMap<>();
        for (int i = 0; i < list1.length; i++){
            map.put(list1[i], i);
        }
        System.out.println(map.get(1));
        for (int i = 0; i < list2.length; i++){
            String one = list2[i];
            if (map.containsKey(one)){
                res.put(one, i + map.get(one));
            }
        }

        int min_sum = Integer.MAX_VALUE;
        for(Map.Entry<String, Integer> entry : res.entrySet()){
            min_sum = Math.min(min_sum, entry.getValue());
        }
        List<String> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : res.entrySet()){
            if(entry.getValue() == min_sum){
                list.add(entry.getKey());
            }
        }
        String[] array = list.toArray(new String[list.size()]);
        return array;
    }

    public static void main(String[] args) {
        FindRestaurant fr = new FindRestaurant();
        String[] list1 = new String[]{"Shogun","Tapioca Express","Burger King","KFC"};
        String[] list2 = new String[]{"Piatti","The Grill at Torrey Pines","KFC","Shogun"};
        String[] rs = fr.findRestaurant(list1, list2);
        System.out.println(Arrays.toString(rs));
    }
}
