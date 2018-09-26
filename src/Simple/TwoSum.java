package Simple;

import java.util.HashMap;

public class TwoSum {
    /*
     *两数之和
     *
     *给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
     *
     * */
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
/*
暴力法
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] == target - nums[i]) {
                return new int[] { i, j };
            }
        }




*/
}
