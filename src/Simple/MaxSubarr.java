package Simple;

public class MaxSubarr {
    //53.最大子序和
    // 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
    //
    //示例:
    //
    //输入: [-2,1,-3,4,-1,2,1,-5,4],
    //输出: 6
    //解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。


    public int maxSubArray(int[] A) {
        //贪心
        if (A == null || A.length == 0){
            return 0;
        }

        int max = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
            max = Math.max(max, sum);
            sum = Math.max(sum, 0);
        }

        return max;
    }



/*
        // Prefix Sum
        public int maxSubArray(int[] A) {
            if (A == null || A.length == 0){
                return 0;
            }

            int max = Integer.MIN_VALUE, sum = 0, minSum = 0;
            for (int i = 0; i < A.length; i++) {
                sum += A[i];
                max = Math.max(max, sum - minSum);
                minSum = Math.min(minSum, sum);
            }

            return max;
        }


    public int maxSubArray(int[] nums) {
        // write your code
        if(nums.length == 0){
            return 0;
        }
        int n = nums.length;
        int[] global = new int[2];
        int[] local = new int[2];
        global[0] = nums[0];
        local[0] = nums[0];
        for(int i = 1; i < n; i ++) {
            local[i % 2] = Math.max(nums[i], local[(i - 1) % 2] + nums[i]);
            global[i % 2] = Math.max(local[i % 2], global[(i - 1) % 2]);
        }
        return global[(n-1) % 2];
    }
*/
}
