package meituan2;

/*
LOGNAME=default;SHELL=/bin/bash;HOME=/home/xiaomei;LOGNAME=xiaomei;
4
SHELL
HOME
LOGNAME
logname

/bin/bash
/home/xiaomei
xiaomei
EMPTY
*/

import java.util.*;

public class four {
    public static void main(String[] args) {
        Map<String, Deque<String>> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = sc.nextInt();
        String[] array = new String[n];
        for(int i = 0; i < n; i++){
            array[i] = sc.next();
        }
        List<String> words = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(c == '='){
                words.add(sb.toString());
                sb = new StringBuilder();
            }else if(c == ';'){
                words.add(sb.toString());
                sb = new StringBuilder();
            }else
                sb.append(c);
        }
        int i = 0;
        while(i < words.size()){
            String s1 = words.get(i++);
            String s2 = words.get(i++);
            if(!map.containsKey(s1)){
                Deque<String> temp = new ArrayDeque<>();
                temp.push(s2);
                map.put(s1, temp);
            }else{
                Deque<String> temp = map.get(s1);
                temp.push(s2);
                map.put(s1, temp);
            }
        }
        for (String s1 : array) {
            if(map.containsKey(s1))
                System.out.println(map.get(s1).peek());
            else
                System.out.println("EMPTY");
        }
    }
}
