package Simple;

public class MergeSortedArr {
    //21.合并有序数组
    //给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
    //
    //说明:
    //
    //初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
    //你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }
        ListNode temp1=l1;
        ListNode temp2=l2;
        ListNode head=null;
        ListNode temp=null;
        if(l1.val <= l2.val){
            head = temp1;
            temp1 = temp1.next;
        } else {
            head = temp2;
            temp2 = temp2.next;
        }
        temp=head;
        while(temp1!=null&&temp2!=null){
            if(temp1.val<=temp2.val){
                temp.next=temp1;
                temp1=temp1.next;
                //temp=temp.next;

            }else{
                temp.next=temp2;
                temp2=temp2.next;
                //temp=temp.next;
            }
            temp=temp.next;
        }
        if(temp1!=null) temp.next=temp1;
        if(temp2!=null) temp.next=temp2;
        return head;
    }
}
