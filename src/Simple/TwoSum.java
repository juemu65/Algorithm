package Simple;

import java.util.*;

public class TwoSum {
    //1.两数之和
    //
    //给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。



    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                //containsKey方法是先计算hash然后使用hash和table.length取摸得到index值，
                // 遍历table[index]元素查找是否包含key相同的值
                // 通过使用 Map 的containsKey() 方法来检测数据（value）是否存在,
                // 如果key存在, 则表明已经获取过一次数据, 那么直接返回该 key 在 Map 中的值.不管是否为 null 都直接返回;
                // 如果 key 不存在, 则去生成或者获取数据, 并放入到 Map 中, 并返回该数据


                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }



}

// 167.两个有序数组的求和
//双指针

/*

        public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
           return new int[0];
         }

         int left = 0;
         int right = nums.length - 1;
         int[] res = new int[2];

         while (left < right) {
             int sum = nums[left] + nums[right];
             if (sum > target) {
                 right--;
             } else if (sum < target) {
                 left++;
             } else {   sum = target;
                 res[0] = left + 1;
                 res[1] = right + 1;
                 return res;
           }
        }
        return new int[0];
    }

    */