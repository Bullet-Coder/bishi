/*
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] numStrs = line.split(" ");
        int n = numStrs.length;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(numStrs[i]);
        }
        int res = 0;
        int sum = 0;
        for (int j = 0; j < n; j++)
            sum += a[j];
        int ave = (int)((double)sum / n + 0.5);
        res = 128-ave;
        System.out.println(res);
    }
}*/
import java.io.Console;
import java.util.Scanner;

class Main {
    public static int get(int x) {
        if (x < 0)
            return 0;
        if (x > 255)
            return 255;
        return x;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cnt = 0;
        int[] a = new int[105];
        while (scanner.hasNext()) {
            a[cnt] = scanner.nextInt();
            cnt++;
        }
        int res = 0, mi = 100000000;
        for (int i = -255; i <= 255; i++) {
            int sum = 0;
            for (int j = 0; j < cnt; j++)
                sum += get(a[j] + i);
            int now = Math.abs(sum - 128 * cnt);
            if (now < mi) {
                mi = now;
                res = i;
            }
        }
        System.out.println(res);
    }
}