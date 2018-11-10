package Simple;

import java.util.*;

public class TraTree {
    //102.二叉树层次遍历
    //自顶向下的层次遍历
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        dfs(root, res, 0);

        return res;
    }

    private void dfs(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }
        if (level == res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);

        dfs(root.left, res, level + 1);
        dfs(root.right, res, level + 1);
    }

    /*
    107.二叉树层次遍历
    自底向上的层次遍历

   public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(root==null) return res;
        List<TreeNode> s1=new ArrayList<TreeNode>();
        List<TreeNode> s2=new ArrayList<TreeNode>();
        s1.add(root);
        while(s1.size()!=0||s2.size()!=0){
            List<Integer> t=new ArrayList<Integer>();
            if(s1.size()!=0){
                while(s1.size()!=0){
                    TreeNode p=s1.get(0);
                    s1.remove(0);
                    t.add(p.val);
                    if(p.left!=null) s2.add(p.left);
                    if(p.right!=null) s2.add(p.right);
                }
            }else{
                while(s2.size()!=0){
                    TreeNode p=s2.get(0);
                    s2.remove(0);
                    t.add(p.val);
                    if(p.left!=null) s1.add(p.left);
                    if(p.right!=null) s1.add(p.right);
                }
            }
            res.add(0,t);
        }
        return res;
    }

    */
}
