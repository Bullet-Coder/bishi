package Tencent;

import java.util.*;

public class two {
    static int res;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Character> set = new HashSet<>();
        res = 0;
        String[] s = new String[n];
        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        backTrack(s, 0, set, n, new HashSet<String>(), new StringBuilder());
        System.out.println(res);
    }

    public static void backTrack(String[] s, int index, Set<Character> set, int n, Set<String> StringSet, StringBuilder sb){
        if(index == n ){
            res++;
            return;
        }
        for(int i = 0; i < s[index].length(); i++){
            if(set.contains(s[index].charAt(i))){
            }else{
                set.add(s[index].charAt(i));
                sb.append(s[index].charAt(i));
                if(index == 2) {
                    if(StringSet.contains(sb.toString()))
                        continue;
                    else{
                        StringSet.add(sb.toString());
                    }
                }
                backTrack(s, index + 1, set, n, StringSet, sb);
                set.remove(s[index].charAt(i));
                sb.deleteCharAt(index);
            }
        }
    }
}
