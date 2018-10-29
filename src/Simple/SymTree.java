package Simple;

public class SymTree {
    //对称二叉树


    public class TreeNode {
      public int val;
      public TreeNode left, right;
      public TreeNode(int val) {
          this.val = val;
          this.left = this.right = null;
     }
  }

    public boolean isSymmetric(TreeNode root) {
        // Write your code here
        if(root == null){
            return true;
        }

        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left == null || right == null){
            return false;
        }else if(left.val == right.val){
            return helper(left.left, right.right) && helper(left.right, right.left);
        }else{
            return false;
        }


    }

}
