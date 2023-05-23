package shuati;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public List<List<Integer>> generate(int numRows) {
        int r = 2, c;
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        result.add(new ArrayList<>());
        result.get(0).add(1);
        if (numRows == 1) {
            return result;
        }
        result.add(new ArrayList<>());
        result.get(1).add(1);
        result.get(1).add(1);
        while (r < numRows) {
            c = 1;
            result.add(new ArrayList<>());
            result.get(r).add(1);
            while (c < r) {
                result.get(r).add(result.get(r - 1).get(c - 1) + result.get(r - 1).get(c));
                c++;
            }
            result.get(r).add(1);
            r++;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 34;
        PascalTriangle pascalTriangle = new PascalTriangle();
        System.out.println(pascalTriangle.generate(n));
    }
}
