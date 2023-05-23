package XieCheng;

import java.util.Scanner;

public class three {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] result = findMinXY(n);
        System.out.println(result[0] + " " + result[1]);
    }

    public static int[] findMinXY(int n){
        double minDifference = Double.POSITIVE_INFINITY;
        int resX = 0, resY = 0;
        int[] nums = new int[(int) Math.sqrt(n) + 1];
        nums[0] = 1;
        for (int i = 1; i <= (int) Math.sqrt(n); i++) {
            nums[i] = nums[i - 1] * i;
        }
        for(int x = 1; x <= (int) Math.sqrt(n); x++){
            if(x == 2)
                continue;
            for (int y = 1; y < n; y++) {
                if(y == 2)
                    continue;
                double difference = Math.abs(nums[x] * y - y - n);
                if(difference < minDifference){
                    minDifference = difference;
                    resX = x;
                    resY = y;
                }
                if(difference == 0)
                    return new int[]{resX, resY};
            }
        }
        return new int[]{resX, resY};
    }

}
//        int[] num = new int[11];
//        double[] dNum = new double[11];
        /*double factorial = 2;
        double min = Integer.MAX_VALUE;
        int resX = 0;
        int resY = 0;
        for(int i = 3; i <= 13; i++){
            factorial *= i;
            double y = n / (factorial - 1);
            if(y < 1) break;
            int intNum = (int)(y + 0.5);
            if(intNum - y == 0 && y != 2) {
                System.out.println(i + " " + intNum);
                break;
            }
            else if(Math.abs(y - intNum) < min) {
                resY = intNum;
                resX = i;
                min = Math.abs(y - intNum);
            }
        }
        if(resX != 0 && resY != 0)
            System.out.println(resX + " " + resY);
        if(n == 2)
            System.out.println(1 + " " + 1);*/