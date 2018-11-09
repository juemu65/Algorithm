package Simple;



public class BalanceTree {
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

