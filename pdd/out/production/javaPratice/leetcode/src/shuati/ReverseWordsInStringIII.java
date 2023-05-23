package shuati;
//按照空格翻转字符串
public class ReverseWordsInStringIII {
    public String reverseWords(String s){
        StringBuffer ret = new StringBuffer();
        int n = s.length();
        int i = 0;
        while(i < n){
            int start = i;
            while (i<n && s.charAt(i) != ' '){
                i++;
            }
            for (int p = start; p < i; p++){
                ret.append(s.charAt(start + i -1 - p));
            }
            while (i < n && s.charAt(i) == ' '){
                i++;
                ret.append(' ');
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String s = "hello world" ;
        ReverseWordsInStringIII rwis = new ReverseWordsInStringIII();
        String ans = rwis.reverseWords(s);
        System.out.println(ans);
    }
}
