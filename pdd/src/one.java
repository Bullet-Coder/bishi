import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder result = new StringBuilder();
        int i = 0;
        while(i < s.length()){
            int count = 0;
            while(i < s.length() && Character.isDigit(s.charAt(i))){
                count = count * 10 + Character.getNumericValue(s.charAt(i));
                i++;
            }
            char c = s.charAt(i);
            for(int j = 0; j < count; j++){
                result.append(c);
            }
            i++;
        }
        System.out.println(result);
    }
}
