package shuati;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParentheses {
    List<String> res = new ArrayList<>();
    public List<String> removeInvalidParentheses(String s) {
        int lmove = 0, rmove = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                lmove++;
            }else if(ch ==')'){
                //前面有左括号，使用一个右括号抵消左括号；没有左括号，右括号++
                if(lmove > 0) lmove--;
                else rmove++;
            }
        }
        //剪枝1： 对于(((((),删除前五个中任意一个左括号效果一样，因此可以在此剪枝
        //剪枝2 对于右括号多于左括号，进行剪枝，通过lcount, rcount进行计数
        //一旦右括号的数目多于左括号，说明当前字符串已经不可能是一个合法的括号集，所以需要剪枝
        dfs(s, 0, lmove, rmove, 0, 0);
        return res;
    }

    public void dfs(String s, int index, int lmove, int rmove, int lcount, int rcount){
        if(lmove == 0 && rmove == 0){
            if(isValid(s)) res.add(s);
            return;
        }
        for(int i = index; i < s.length(); i++){
            char ch = s.charAt(i);
            // 剪枝1
            //这个意思是说：对于（（（（）这个字符串，如果我已经删掉了其中一个（，那么我就不用再往下走了，
            // 因为删除任意一个（效果一样，而且我们每次深度遍历的时候都只会删除一个字符，所以如果后面的字符还跟前面的一样，直接跳过
            if(i == index || ch != s.charAt(i - 1)){
                //删除多余左括号
                if(lmove > 0 && ch == '(')
                    dfs(s.substring(0, i) + s.substring(i + 1), i, lmove - 1, rmove, lcount, rcount);
                if(rmove > 0 && ch == ')')
                    dfs(s.substring(0, i) + s.substring(i + 1), i, lmove, rmove - 1, lcount, rcount);
            }
            //剪枝2
            if(ch == '(') lcount++;
            if(ch == ')') rcount++;
            if(rcount > lcount) break;
        }

    }


    public boolean isValid(String s){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(')
                count++;
            else if(s.charAt(i) == ')'){
                count--;
                if(count < 0) return false;
            }
        }
        return count == 0;
    }

    public static void main(String[] args) {
        String s = "(((()";
        RemoveInvalidParentheses rip = new RemoveInvalidParentheses();
        rip.removeInvalidParentheses(s);

    }
}
