package Lei;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Queue<Integer>[] a = new LinkedList[6];
        for (int i = 1; i < 6; i++)
            a[i] = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String op;
            op = scanner.next();
            if (op.equals("a")) { //有新来的顾客就添加到对于的队列尾
                int x, y;
                x = scanner.nextInt();
                y = scanner.nextInt();
                a[y].offer(x);
            } else {
                for (int j = 1; j <= 5; j++) { //办理业务就从1到5遍历
                    if (!a[j].isEmpty()) { //有非空的就输出并弹出队首第一个
                        System.out.println(a[j].poll());
                        break;
                    }
                }
            }
        }
    }
}
