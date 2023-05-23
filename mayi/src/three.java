import java.util.Scanner;

public class three {
    static  int MOD = (int) 1e9 + 7;
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i + 1;
        }
        long ans = 0;
        do{
            ans += calcWeight(a);
            ans %= MOD;
        }while(nextPermutation(a));
        System.out.println(ans);
    }*/
    public static void main(String[] args) {
        int c = 2;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 1;
        if(n == 1) {
            System.out.println(0);
        }else {
            for (int i = 2; i <= n; i++) {
                res = (res * (i - 1)) % MOD;
            }
            System.out.println((res * 2) % MOD);
        }

    }
    public static long calcWeight(int[] a){
        int n = a.length;
        long res = 0;
        for(int i = 0; i < n - 1; i++){
            if((a[i] * a[i + 1] % 2 == 1))
                res++;
        }
        return res;
    }

    public static boolean nextPermutation(int[] a){
        int n = a.length;
        int i, j;
        for(i = n - 2; i >= 0; i--) {
            if (a[i] < a[i + 1])
                break;
        }
        if(i < 0)
            return false;
        for(j = n - 1; j > i; j--){
            if(a[j] > a[i])
                break;
        }
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
        for(int p = i + 1, q = n - 1; p < q; p++, q--){
            temp = a[p];
            a[p] = a[q];
            a[q] = temp;
        }
        return true;
    }

}
