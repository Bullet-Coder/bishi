package shuati;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeKLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> ls = new ArrayList<>();
        ListNode dummy = new ListNode(-1);
        for(ListNode node : lists){
            while(node != null){
                ls.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(ls);
        ListNode head = new ListNode(ls.get(0));
        dummy.next = head;
        for(int i = 1; i < ls.size(); i++){
            ListNode cur = new ListNode(ls.get(i));
            head.next = cur;
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode n3 = new ListNode(5);
        ListNode n2 = new ListNode(4, n3);
        ListNode n1 = new ListNode(1, n2);

        ListNode n6 = new ListNode(4);
        ListNode n5 = new ListNode(3, n6);
        ListNode n4 = new ListNode(1, n5);

        ListNode n8 = new ListNode(6);
        ListNode n7 = new ListNode(2, n8);
        ListNode[] lists = {n1, n4, n7};
        MergeKLists mkl = new MergeKLists();
        mkl.mergeKLists(lists);
        double i = 3.14;
        System.out.println(Double.toString(i));
    }
}
