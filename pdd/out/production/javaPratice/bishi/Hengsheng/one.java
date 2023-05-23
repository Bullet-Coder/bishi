package Hengsheng;

import java.util.Scanner;

public class one {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int num1 = findMax(num);
        for(int i = num1; i >=153 ; i--){
            if(count(i) > num)
                continue;
            if(isValid(i))
                System.out.println(i);
        }
    }
    public static boolean isValid(int num){
        int sum = 0;
        int num1 = num;
        while(num1 > 0){
            sum += Math.pow(num1 % 10, 3);
            num1 /= 10;
        }
        if(num == sum)
            return true;
        else return false;
    }
    public static int count (int num){
        int sum = 0;
        int num1 = num;
        int len = String.valueOf(num).length();
        while(num1 > 0){
            sum += Math.pow(num1 % 10, len);
            num1 /= 10;
        }
        return sum;
    }

    public static int findMax(int num){
        int l = 10, r = num;
        while(l <= r){
            int mid = (l + r) / 2;
            if(count(mid) > num)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }
}
