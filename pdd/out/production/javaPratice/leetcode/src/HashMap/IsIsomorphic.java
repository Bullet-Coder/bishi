package HashMap;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
    public boolean isIsomorphic(String s, String t) {
//        Map<Object, Integer> map = new HashMap<>();
//        for (Integer i = 0; i < s.length(); i++) {
////            map.put(s.charAt(i), i);
////            System.out.println(String.valueOf(t.charAt(i)));
////            map.put(String.valueOf(t.charAt(i)), i);
//            if (map.put(s.charAt(i), i) != map.put(String.valueOf(t.charAt(i)), i)) {
//                return false;
//            }
//        }
//        return true;
        if(s.length() != t.length()) return false;

        //定义HashMap用于映射两个字符串的每一个字符
        Map<Character, Character> hashMap = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
            //查看s中的字符是否已经映射到对应的t中的字符
            if(hashMap.containsKey(s.charAt(i))){
                //如果已经映射到t中对应的字符，则判断s中当前字符映射的字符是否与t中对应的的字符相等
                if(hashMap.get(s.charAt(i)) != t.charAt(i)){
                    //不相等直接返回false
                    return false;
                }
            }else{ //如果没有映射到t中对应的字符
                //判断s中是否有已经映射过当前t中对应的字符
                if(hashMap.containsValue(t.charAt(i))){
                    //已经映射过则返回false
                    return false;
                }
                //没有映射过，则建立映射关系
                hashMap.put(s.charAt(i), t.charAt(i));
            }
        }
        //s中所有字符都正确映射到t中的字符，返回true
        return true;

    }

    public static void main(String[] args) {
        String s = "paper";
        String t = "title";
        IsIsomorphic ii = new IsIsomorphic();
        System.out.println(ii.isIsomorphic(s, t));
    }
}
