import java.util.*;

public class three {

    static long[] ten = new long[14];
    static long[] dd = new long[14];
    static long[] res = new long[14];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        precompute();
        for (int w = 0; w < t; w++) {
            long x = sc.nextLong();
            long y = sc.nextLong();
            x -= 1;
            long xx = bs(x);
            long yy = bs(y);
            long num1 = calc3(yy) - calc3(xx);
            long num2 = calc4(yy) - calc4(xx);
            System.out.println(num2 + " " + num1);
        }
        sc.close();
    }

    public static long calc1(long x, int dn) {
        long s = ten[dn - 1];
        long num = x - s + 1;
        long res = num * dn + num - 1;
        return res;
    }

    public static void precompute() {
        for (int i = 0; i < 14; i++) {
            ten[i] = (long) Math.pow(10, i);
        }
        for (int i = 1; i < 14; i++) {
            dd[i] = calc1(ten[i] - 1, i) + 1;
        }
        for (int i = 1; i < 14; i++) {
            res[i] = res[i - 1] + dd[i];
        }
    }

    public static long calc2(long x, int dn) {
        return calc1(x, dn) + res[dn - 1];
    }

    public static long bs(long x) {
        long l = 1;
        long r = 1000000000000L;
        while (l <= r) {
            long mid = (l + r) / 2;
            int dn = Long.toString(mid).length();
            long val = calc2(mid, dn);
            if (x <= val) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static long calc3(long x) {
        return (x - 1) / 3;
    }

    public static long calc4(long x) {
        return x - 1 - calc3(x);
    }
}
