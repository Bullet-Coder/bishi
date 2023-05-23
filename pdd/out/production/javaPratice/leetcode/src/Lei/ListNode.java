package Lei;



public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(){ }
    public ListNode(int val, ListNode next){this.val = val; this.next = next; }

    public ListNode(int val){ this.val = val;}

    public ListNode makeNode(ListNode head, int[] arr){
        head.val = arr[0];
        ListNode node = head;
        for(int i = 1; i < arr.length; i++){
            node.next = new ListNode(arr[i]);
            node = node .next;
        }
        return  head;
    }
}
