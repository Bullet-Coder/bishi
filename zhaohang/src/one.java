import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()) {
            int k = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
//        System.out.println(s);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (i % (k + 1) == 0)
                    continue;
                sb.append(s.charAt(i));
            }
            System.out.println(sb.toString());
        }
    }
}
