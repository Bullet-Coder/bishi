import java.util.Scanner;

public class two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();
        n = n * 2;
        char[] arr = new char[]{'r', 'e', 'd'};
        int now = 0;
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            long val = getMin(n);
            n -= val * val + val;
            for(int j = 0; j < val; j++){
                sb.append(arr[now]);
            }
            now = (now + 1) % 3;
        }
        System.out.println(sb);
    }
    public static long getMin(long n){
        long l = 0, r = (long) 1e5;
        long res = 0;
        while(l <= r){
            long m = (l + r) /2;
            if(m * m + m <= n){
                res = m;
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return res;
    }
}
