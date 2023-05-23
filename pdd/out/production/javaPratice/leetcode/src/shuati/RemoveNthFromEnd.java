package shuati;

import Lei.ListNode;

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // Deque<ListNode> deque = new ArrayDeque();
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        int cnt = 0;
        while(cur != null){
            cur = cur.next;
            cnt++;
        }

        for(int i = 1; i < cnt - n - 1  ; i++){
            head = head.next;
        }
        head.next = head.next.next;
        return dummy.next;
    }


    public static void main(String[] args) {
        ListNode node = new ListNode();
        node.makeNode(node, new int[]{1});
        removeNthFromEnd(node, 1);
    }
}

