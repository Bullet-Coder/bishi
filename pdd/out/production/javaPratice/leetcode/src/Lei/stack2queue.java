package Lei;

import java.util.LinkedList;

public class stack2queue {
    LinkedList<Integer> A, B;
    public stack2queue() {
        A = new LinkedList<Integer>();
        B = new LinkedList<Integer>();
    }
    public void appendTail(int value) {
        A.addLast(value);
    }
    public int deleteHead() {
        if(!B.isEmpty()) return B.removeLast();
        if(A.isEmpty()) return -1;
        while(!A.isEmpty())
            B.addLast(A.removeLast());
        return B.removeLast();
    }

    public static void main(String[] args) {
        stack2queue sq = new stack2queue();
        sq.appendTail(1);
        sq.appendTail(4);
        sq.appendTail(2);
        sq.appendTail(7);
        System.out.println(sq.deleteHead());
        sq.appendTail(3);
        sq.appendTail(5);
        sq.appendTail(6);
        System.out.println(sq.deleteHead());
    }
}
