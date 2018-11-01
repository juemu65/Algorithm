package Simple;



public class SameTree {
    //100.相同的树
    //检查两棵二叉树是否等价。
    // 等价的意思是说，首先两棵二叉树必须拥有相同的结构，
    // 并且每个对应位置上的节点上的数都相等。


    public boolean isIdentical(TreeNode a, TreeNode b) {
        // write your code here

        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        if (a.val != b.val) {

            return false;
        }

        if (a.val == b.val){
            return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
        }else{
            return false;
        }

    }
}
