package shuati;

import Lei.ListNode;

public class DeleteDuplicates {

    public static ListNode deleteDuplicates (ListNode head) {
        // write code here
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                int temp = cur.next.val;
                while(cur.next != null && cur.next.val == temp)
                    cur.next = cur.next.next;
            }else
                cur = cur.next;
        }
        return dummy.next;
    }



    public static void main(String[] args) {
        ListNode head = new ListNode();
        head.makeNode(head, new int[]{1,2,3,3,3,4,4,4,5});
        deleteDuplicates(head);


    }
}


