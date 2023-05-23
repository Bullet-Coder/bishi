package shein;

import java.util.*;
import java.util.function.Function;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 查找最长子字符串
     * @param input string字符串 待查找的字符串
     * @return string字符串一维数组
     */
    public static String[] matchMaxLengthSubString (String input) {
        // write code here
        int n = findMaxLength(input);
        List<String> ls = new ArrayList<>();
        int l = 0, r = 0;
        Set<Character> set = new HashSet<>();
        List<Character> lsch = new ArrayList<>();
        while(r < input.length()){
            char ch = input.charAt(r);
            if(!set.contains(ch)){
                set.add(ch);
                lsch.add(ch);
                if(set.size() == n){
                    StringBuilder sb = new StringBuilder();
                    for(char c : lsch){
                        sb.append(c);
                    }
                    ls.add(sb.toString());
                }
                r++;
            }else{
                while(set.contains(ch)){
                    char chl = input.charAt(l);
                    set.remove(chl);
                    lsch.remove(0);
                    l++;
                }
            }
        }
        String[] strings = ls.toArray(String[]::new);
//        Arrays.stream(strings).forEach(System.out::println);
        return strings;
    }

    public static int findMaxLength(String s){
        int l = 0, r = 0;
        Set<Character> set = new HashSet<>();
        int max = 0;
        while(r < s.length()){
            char ch = s.charAt(r);
            if(!set.contains(ch)){
                set.add(ch);
                max = Math.max(r - l + 1, max);
                r++;
            }else{
                while(set.contains(ch)){
                    char chl = s.charAt(l);
                    set.remove(chl);
                    l++;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        matchMaxLengthSubString("asdfghjklasdfghjkl");
        Integer var1=new Integer(1);
        Integer var2=var1;
        doSomething(var2);
        System.out.print(var1);
        System.out.print(var1==var2);
    }
    public static void doSomething(Integer integer){
        integer = new Integer(2);
    }
}