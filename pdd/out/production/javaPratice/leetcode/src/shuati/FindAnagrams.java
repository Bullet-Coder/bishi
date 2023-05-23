package shuati;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindAnagrams {
    public static List<Integer> findAnagrams(String s, String p) {
        int sLen = s.length(), pLen = p.length();
        Set<Character> pSet = new HashSet<>();
        Set<Character> sSet = new HashSet<>();
        for(int i = 0; i < pLen; i++){
            pSet.add(p.charAt(i));
        }
        if(sLen < pLen) return new ArrayList<Integer>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < sLen; i++){
            if(i < pLen) {
                sSet.add(s.charAt(i));
                continue;
            }
            if(sSet.equals(pSet)){
                res.add(i - pLen);
            }
            sSet.remove(s.charAt(i - pLen));
            sSet.add(s.charAt(i));
        }
        return res;
    }

    public static void main(String[] args) {
        findAnagrams("cbaebabacd", "abc");
    }
}
