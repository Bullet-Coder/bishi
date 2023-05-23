package lambda;

public class Program {

    public static void main(String[] args) {
//    Cal c = new Cal(){
//
//        @Override
//        public int add(int a, int b) {
//            return a + b;
//        }
//    };
        Cal c = (int a, int b)->{
            return a + b;
        };
        System.out.println(c.add(1, 2));
    }

    interface  Cal{
        int add(int a, int b);
    }
}
