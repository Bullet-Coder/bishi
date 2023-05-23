package lianxi;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            double num = sc.nextDouble();
            System.out.println((int)(num + 0.5));
        }
    }
}
