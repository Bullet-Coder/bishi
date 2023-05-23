import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] array = sc.next().toCharArray();
        int[] nums = new int[3];
        for(char ch : array){
            if(ch == 'a')
                nums[0]++;
            if(ch == 'b')
                nums[1]++;
            if(ch == 'c')
                nums[2]++;
        }
        int res =0;
        if(nums[0] > nums[1] + nums[2])
            res = (nums[0] - nums[1] - nums[2]) / 2;
        else
            res = (nums[1] + nums[2] - nums[0]) / 2;
        System.out.println(res);
    }
}
