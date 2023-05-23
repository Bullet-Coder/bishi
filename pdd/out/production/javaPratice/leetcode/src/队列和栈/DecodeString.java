package 队列和栈;

//输入：s = "3[a]2[bc]"
//输出："aaabcbc"
//输入：s = "3[a2[c]]"
//输出："accaccacc"

import java.util.ArrayDeque;
import java.util.Deque;


public class DecodeString {
    public String decodeString(String s) {
        int num = 0;
        StringBuilder res = new StringBuilder();
        Deque<Integer> numStack = new ArrayDeque<>();
        Deque<StringBuilder> resStack = new ArrayDeque<>();
            for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                num = num * 10 + c - '0';
            }else if(c == '['){
                resStack.push(res);
                numStack.push(num);
                res = new StringBuilder();
                num = 0;
            }else if(c == ']'){
                StringBuilder pre = resStack.pop();
                int n = numStack.pop();
                for(int i = 0; i < n; i++){
                    pre.append(res);
                }
                res = pre;
            }else {
                res.append(c);
            }
        }
            return res.toString();
    }

    public static void main(String[] args) {
        String s = "3[a2[c]]";
        DecodeString ds = new DecodeString();
        System.out.println(ds.decodeString(s));
    }
}
