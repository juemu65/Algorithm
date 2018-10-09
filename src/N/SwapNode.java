package N;

public class SwapNode {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        while(temp != null && temp.next != null) {
            int k = temp.next.val;
            temp.next.val = temp.val;
            temp.val = k;
            temp = temp.next.next;
        }

        return head;
    }
}
