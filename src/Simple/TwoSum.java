package Simple;

import java.util.HashMap;

public class TwoSum {
    //1.两数之和
    //
    //给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

    //暴力法
//    for (int i = 0; i < nums.length; i++) {
//        for (int j = i + 1; j < nums.length; j++) {
//            if (nums[j] == target - nums[i]) {
//                return new int[] { i, j };
//            }
//        }


    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        //HashMap
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) != null) {
                int[] result = {map.get(numbers[i]), i+1};
                return result;
            }
            map.put(target - numbers[i], i+1);
        }

        int[] result = {};
        return result;


    }



}

// 167.两个有序数组的求和
//双指针

//public int[] twoSum(int[] nums, int target) {
//        if (nums == null || nums.length == 0) {
//            return new int[0];
//        }
//
//        int left = 0;
//        int right = nums.length - 1;
//        int[] res = new int[2];
//
//        while (left < right) {
//            int sum = nums[left] + nums[right];
//            if (sum > target) {
//                right--;
//            } else if (sum < target) {
//                left++;
//            } else { // sum == target
//                res[0] = left + 1;
//                res[1] = right + 1;
//                return res;
//            }
//        }
//        return new int[0];
//    }
