package Hard;

public class firstMissingPositive {
    //41. 缺失的第一个正数
    //给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
    //
    //示例 1:
    //
    //输入: [1,2,0]
    //输出: 3
    //示例 2:
    //
    //输入: [3,4,-1,1]
    //输出: 2
    //示例 3:
    //
    //输入: [7,8,9,11,12]
    //输出: 1
    //说明:

    public int firstMissingPositive(int[] A) {
        if (A == null) {
            return 1;
        }

        for (int i = 0; i < A.length; i++) {
            while (A[i] > 0 && A[i] <= A.length && A[i] != (i+1)) {
                int tmp = A[A[i]-1];
                if (tmp == A[i]) {
                    break;
                }
                A[A[i]-1] = A[i];
                A[i] = tmp;
            }
        }

        for (int i = 0; i < A.length; i ++) {
            if (A[i] != i + 1) {
                return i + 1;
            }
        }

        return A.length + 1;
    }
}
