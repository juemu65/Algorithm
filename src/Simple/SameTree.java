package Simple;



public class SameTree {
    //100.相同的树
    //检查两棵二叉树是否等价。
    // 等价的意思是说，首先两棵二叉树必须拥有相同的结构，
    // 并且每个对应位置上的节点上的数都相等。
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public boolean isIdentical(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        if (p.val != q.val) {
            //这里不能写成a != b， 因为a和b分别是两棵树的根节点，显然不同。
            //这里要比较的是a和b的值是否相同，如果数值不同，直接返回false, 如果相同，再看他们的左右子树是否一致
            return false;
        }
        return isIdentical(p.left, q.left) && isIdentical(p.right, q.right);

    }
}
