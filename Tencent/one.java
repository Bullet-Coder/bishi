package Tencent;

public class one {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(3);
        ListNode l7 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        reorderList(l1);
    }

    public static ListNode reorderList (ListNode head) {
        // write code here
        ListNode dummy = new ListNode(-1);
        dummy.val = -1;
        dummy.next = head;
        ListNode curr = dummy;
        ListNode newHead = new ListNode(-1);
        newHead.val = -1;
        ListNode tail = newHead;
        while(curr.next != null && curr.next.next != null){
            ListNode node1 = curr.next;
            ListNode node2 = curr.next.next;
            tail.next = node2;
            node1.next = node2.next;
            node2.next = null;
            tail = tail.next;
            tail.next = node1;
            tail = tail.next;
            curr = curr.next.next;
        }
        if(curr.next != null){
            tail.next = curr.next;
        }

        ListNode prev = new ListNode(-1);
        prev.val = -1;
        prev.next = newHead.next;
        curr = newHead.next;
        head = newHead.next;

        while(curr != null && curr.next != null){
            ListNode node1 = curr;
            ListNode node2 = curr.next;

            node1.next = node2.next;
            node2.next = node1;
            prev.next = node2;
            prev = node1;
            curr = node1.next;
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next = null;
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(){
    }
}
