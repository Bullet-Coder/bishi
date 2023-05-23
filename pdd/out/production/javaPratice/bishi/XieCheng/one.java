package XieCheng;

import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int res = 0;
        for(char ch : s.toCharArray()){
            if(ch == '6')
                res++;
            else if(ch == '8')
                res += 2;
            else if(ch == '9')
                res++;
            else if(ch == '0')
                res++;
            else
                continue;
        }
        System.out.println(res);
    }
}
