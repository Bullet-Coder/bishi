package lambda;

public class TestLambda {
    public static void main(String[] args) {
        Ilike like = () -> {
            System.out.println("这是一个lambda");
            return 1;
        };
        int lambda = like.lambda();
    }
}

interface Ilike{
    int lambda();
}