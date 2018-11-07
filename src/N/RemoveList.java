package N;

public class RemoveList {
    //19.删除链表的倒数第N个节点
    //给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。


    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        for(int i =1 ;i<n ;i++){
            fast = fast.next;
        }
        ListNode temp = head;
        while(fast.next != null){
            temp = slow;
            fast = fast.next;
            slow = slow.next;
        }
        if(temp == slow){
            return slow.next;
        }else{
            temp.next=temp.next.next;
        }
        return head;
    }
}
