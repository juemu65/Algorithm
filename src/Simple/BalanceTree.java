package Simple;



public class BalanceTree {

    //110. 平衡二叉树
    //给定一个二叉树，判断它是否是高度平衡的二叉树。
    //
    //本题中，一棵高度平衡二叉树定义为：
    //
    //一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public boolean isBalanced(TreeNode root) {
        if(height(root)>-1){
            return true;
        } else {
            return false;
        }
    }
    public boolean bb(int h_lf,int h_ri)
    {
        return h_lf-h_ri>0?h_lf-h_ri<=1:h_ri-h_lf<=1;
    }
    public int height(TreeNode t) {
        if(t == null) {
            return 0;
        }
        int left = height(t.left);
        if(left == -1) {
            return -1;
        }
        int right = height(t.right);
        if(right == -1) {
            return -1;
        }

        if(!bb(left,right)){
            return -1;
        }
        return max(left,right)+1;
    }

    public int max(int a,int b){
        return a>b?a:b;
    }
}

