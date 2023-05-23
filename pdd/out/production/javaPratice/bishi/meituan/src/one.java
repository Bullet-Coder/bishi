import java.util.Scanner;
/*1.小美有一个由数字字符组成的字符串，现在她想对这个字符串进行一些修改，具体地，她可以将这个字符串中任意位置字符修改为任意的数字字符。她想知道，至少进行多少次修改，可以使得修改后的字符串不包含两个连续相同的字符？
        例如，对于字符串”111222333"，她可以进行3次修改将其变为"
        121212313"
.*/
public class one {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int n = s.length();
        int count = 0;
        int i = 1;
        while (i < n) {
            if(s.charAt(i) == s.charAt(i - 1)){
                i++;
                count++;
            }
            i++;
        }
        System.out.println(count);
    }
}
