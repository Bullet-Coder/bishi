import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            String s = sc.next().trim();
            boolean canFormBaidu = canFormBaidu(s);
            if(canFormBaidu)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }

    public static boolean canFormBaidu(String s){
        int[] count = new int[52];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(Character.isUpperCase(ch)){
                count[ch - 'A' + 26]++;
            }else{
                count[ch - 'a']++;
            }
        }
        if(count[27] >= 1 && count[0] >= 1 && count[8] >= 1 && count[3] >= 1 && count[20] >= 1)
            return true;
        else
            return false;
    }
}
