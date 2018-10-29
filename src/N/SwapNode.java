package N;

public class SwapNode {

    //两两交换链表中的节点
    //给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
    //
    //示例:
    //
    //给定 1->2->3->4, 你应该返回 2->1->4->3.

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
