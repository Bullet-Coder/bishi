package shuati;
// 去除倒数第n个链表节点
public class RemoveNthNodeFromEndofList {
    class ListNode{
        int val;
        ListNode next;
        ListNode(int x, ListNode head) {val = x;}
    }
    ListNode head ;
    int size ;
    public RemoveNthNodeFromEndofList() {
        size = 0;
        head = new ListNode(0, head);
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0,head);
        ListNode first = head;
        ListNode second = dummy;
        for (int i = 0; i < n; ++i){
            first = first.next;
        }
        while (first !=null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        ListNode ans = dummy.next;
        return ans;
    }
}
