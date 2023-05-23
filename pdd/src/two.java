import java.util.*;

public class two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n = sc.nextInt();
        while(t-- > 0){
            int res = 0;
            List<Integer> plane = new LinkedList<>();
            for(int i = 0; i < n; i++){
                plane.add(sc.nextInt());
            }
            plane.sort(Collections.reverseOrder());
            while(!plane.isEmpty()){
                if(plane.get(0) > 1) {
                    plane.remove(0);
                    res++;
                }else{
                    break;
                }
            }
            int size = plane.size();
            if(size == 0){
                System.out.println(res);
            }
            else if(size % 2 == 0){
                res += size / 2;
            }else{
                res += size / 2 + 1;
            }
            System.out.println(res);
        }
    }
}
