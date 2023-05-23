public class Test {
    int a = 10;
    public static void main(String[] args) {
        Test t = new Test();
        t.test(3);
    }
    //局部final变量a,b
    public void test(final int b) {//jdk8在这里做了优化, 不用写,语法糖，但实际上也是有的，也不能修改
//匿名内部类
        new Thread(){
            public void run() {
                System.out.println(a);
                System.out.println(b);
            };
        }.start();
    }
}
class OutClass {
    private final int age = 12;
    public void outPrint(final int x) {
        class InClass {
            public void InPrint() {
                System.out.println(x);
                System.out.println(age);
            }
        }
        new InClass().InPrint();
    }

    public static void main(String[] args) {
        OutClass oc = new OutClass();
        oc.outPrint(2);
    }
}