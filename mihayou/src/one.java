import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sign = 1;
        boolean flag = true;
        int start = n;
        while(n != 0){
            int i = binSearch(n,start);
            start = i;
            i = (int) Math.pow(3, i);
            n -= i;
            int res = i * sign;
            if(res > 0){
                if(flag) {
                    System.out.print(res);
                    flag = false;
                }
                else{
                    System.out.print("+" + res);
                }
            }else{
                System.out.print(res);
            }
            if(n < 0){
                n = -n;
                sign = -sign;
            }
        }

    }

    public static int binSearch(int n, int start){
        int i = 0, j = start-1;
        while(i < j){
            int mid = (i + j) / 2;
            if(Math.pow(3, mid) < n){   
                i = mid;
            }else if(Math.pow(3, mid) > n){
                j = mid - 1;
            }else{
                return mid;
            }
        }
        return  i;

    }
}
