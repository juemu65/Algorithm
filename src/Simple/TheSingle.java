package Simple;

public class TheSingle {
    //给出2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
    //该题只规定出线一个单独数字

    public int singleNumber(int[] A) {
        if(A == null || A.length == 0) {
            return -1;
        }
        int rst = 0;
        for (int i = 0; i < A.length; i++) {
            rst ^= A[i];
        }
        return rst;
    }
}
