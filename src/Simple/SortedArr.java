package Simple;

public class SortedArr {
    //26.删除排序数组中的重复数字
    //给定一个排序数组，在原数组中删除重复出现的数字，使得每个元素只出现一次，并且返回新的数组的长度。
    //
    //不要使用额外的数组空间，必须在原地没有额外空间的条件下完成。

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int size = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[size]) {
                nums[++size] = nums[i];
            }
        }
        return size + 1;
    }

    /*
    //80.排序链表中重复元素
    //允许出现两次

    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

    public int removeDuplicates(int[] nums) {
         int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count < 2 || nums[i] > nums[count - 2]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }


    //83.排序链表中重复元素
    //允许出现一次
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode node = head;
        while (node.next != null) {
            if (node.val == node.next.val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return head;
    }

    */
}
