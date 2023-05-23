import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class two {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        List<student> list= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            String[] parts = line.split(" ");
            String name = parts[0];
            int chinese = parseScore(parts[1]);
            int math = parseScore(parts[2]);
            int english = parseScore(parts[3]);
            int totle = parseScore(parts[4]);
            list.add(new student(name, chinese, math, english, totle));
        }
        Collections.sort(list);
        for(int i = 0; i < n; i++){
            student student = list.get(i);
            System.out.println(student);
            int ave = (int)((5 / 2) + 0.5);

        }
    }

    private static int parseScore(String scoreStr){
        if("?".equals(scoreStr)){
            return -1;
        }else{
            return Integer.parseInt(scoreStr);
        }
    }
    static class  student implements Comparable<student>{
        String name;
        int chinese, math, english;
        int totle;

        public student(String name, int chinese, int math, int english, int totle) {
            if(chinese != -1 && math != -1 && english != -1 && totle == -1){
                totle = chinese + math + english;
            }else if(chinese != -1 && math != -1 && english == -1 && totle != -1){
                english = totle - chinese - math;
            }else if(chinese != -1 && math == -1 && english != -1 && totle != -1){
                math = totle - chinese - english;
            }else if(chinese == -1 && math != -1 && english != -1 && totle != -1){
                chinese = totle - math - english;
            }
            this.name = name;
            this.chinese = chinese;
            this.math = math;
            this.english = english;
            this.totle = totle;
        }


        @Override
        public int compareTo(student other) {
            if(this.totle != other.totle){
                return other.totle - this.totle;
            }else if(this.name.equals("?") && !other.name.equals("?")){
                return 1;//表示新的放在旧的后面
            }else if(!this.name.equals("?") && other.name.equals("?")){
                return -1;//表示交换位置，新的放在旧的前面
            }else{
                return this.name.compareTo(other.name);
            }

        }

        @Override
        public String toString() {
            String chinsesStr = chinese == -1 ? "?" : String.valueOf(chinese);
            String mathStr = math == -1 ? "?" : String.valueOf(math);
            String englishStr = english == -1 ? "?" : String.valueOf(english);
            String totalStr = totle == -1 ? "?" : String.valueOf(totle);
            return String.format("%s %s %s %s %s", name, chinsesStr, mathStr, englishStr, totalStr);
        }
    }
}
