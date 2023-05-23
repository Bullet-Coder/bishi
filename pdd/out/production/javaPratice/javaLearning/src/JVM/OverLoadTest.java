package src.JVM;

public class OverLoadTest {
    static class Mobile{
    }

    static class Phone extends Mobile{
    }

    static class Pad extends Mobile{
    }

    static class TX{
        public void test(Mobile mobile){
            System.out.println("tx-mobile");
        }
        public void test(Phone phone){
            System.out.println("tx-phone");
        }
        public void test(Pad pad){
            System.out.println("tx-pad");
        }
    }

    static class QQ extends TX{

        @Override
        public void test(Mobile mobile){
            System.out.println("qq-mobile");
        }
        @Override
        public void test(Phone phone){
            System.out.println("qq-phone");
        }
        @Override
        public void test(Pad pad){
            System.out.println("qq-pad");
        }

    }

    static class WeChat extends TX{
        @Override
        public void test(Mobile mobile){
            System.out.println("wc-mobile");
        }
        @Override
        public void test(Phone phone){
            System.out.println("wc-phone");
        }
        @Override
        public void test(Pad pad){
            System.out.println("wc-pad");
        }
    }

    public static void main(String[] args) {
        TX qq = new QQ();
        TX wc = new WeChat();

        Phone phone = new Phone();
        Mobile pad = new Pad();

        qq.test(phone);
        wc.test(pad);
    }
}