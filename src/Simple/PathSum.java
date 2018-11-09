package Simple;

public class PathSum {
    //112.路径总和
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null){
            return false;
        }
        return decide(root,sum);
    }
    public boolean decide(TreeNode root, int sum){
        if(root==null){
            return false;
        }
        if(root.left==null&&root.right==null&&root.val==sum){
            return true;
        }
        return decide(root.left,sum-root.val)|| decide(root.right,sum-root.val);
    }
}
