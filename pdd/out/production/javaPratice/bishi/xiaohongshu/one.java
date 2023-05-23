package xiaohongshu;

import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        char[] array = new char[n];
        for(char c : s.toCharArray()){
            if(c > 'c') sb.append( (char)(c - 3));
            else{
                if(c == 'a') sb.append('x');
                else if(c == 'b') sb.append('y');
                else  sb.append('z');
            }
        }
        System.out.println(sb.toString());

    }
}
