package shuati;

public class StrToInt {
    public int strToInt(String str) {
        char[] c = str.trim().toCharArray();
        if(c.length == 0) return 0;
        int bodry = Integer.MAX_VALUE/10;
        int sign = 1, i = 1 , res = 0;;
        if(c[0] == '-') sign = -1;
        else if(c[0] != '+') i = 0;
        for(int j = i; j < c.length; j++){
            if(c[j] < '0' || c[j] > '9') break;
            int digit = c[j] - '0';
            if(res > bodry || res == bodry && digit > bodry % 10) return sign ==1? Integer.MAX_VALUE : Integer.MIN_VALUE;
            res = res * 10 + digit;
        }
        return sign *res;
    }

    public static void main(String[] args) {
        StrToInt s2i = new StrToInt();
        String s = "2147483646";
        System.out.println(s.substring(0, 5));
        int res = s2i.strToInt(s);
        System.out.println(res);
        System.out.println('v' - 1 + 9.00);
    }
}
