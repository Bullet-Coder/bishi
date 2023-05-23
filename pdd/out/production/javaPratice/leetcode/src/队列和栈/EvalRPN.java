package 队列和栈;

public class EvalRPN {
    public int evalRPN(String[] tokens) {
        int[] stack = new int[tokens.length / 2 + 1];
        int i = -1;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack[--i] = stack[i] + stack[i + 1];
                    break;
                case "-":
                    stack[--i] -= stack[i + 1];
                    break;
                case "*":
                    stack[--i] *= stack[i + 1];
                    break;
                case "/":
                    stack[--i] /= stack[i + 1];
                    break;
                default:
                    stack[++i] = Integer.parseInt(token);
            }
        }
        return stack[i];

    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        EvalRPN ep = new EvalRPN();
        System.out.println(ep.evalRPN(tokens));
    }
}
