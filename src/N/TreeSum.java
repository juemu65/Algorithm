package N;

import java.util.*;

public class TreeSum {
//15.三数之和
//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
//
//例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]

public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    if(nums.length < 3 || nums[0] > 0 || nums[nums.length-1] < 0)
        return result;

    for(int i = 0;i < nums.length-2;i++){
        if(nums[i] > 0)
            break;
        if(i>0 && nums[i] == nums[i-1])
            continue;
        int target = 0 - nums[i];
        int left = i+1;
        int right = nums.length-1;

        while (right>left){
            if(nums[right] + nums[left] == target){
                ArrayList temp = new ArrayList();
                temp.add(0-target);
                temp.add(nums[left]);
                temp.add(nums[right]);
                result.add(temp);
                while (right > left && nums[right] == nums[right-1])
                    right--;
                while (right > left && nums[left] == nums[left+1])
                    left++;
                left++;
            }
            else if(nums[right] + nums[left] > target)
                right--;
            else
                left++;
        }
    }
    return result;
}


}


/*Nearly Three Sum

//   16.最接近的三数之和
//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
//
//例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
		int res = 0;
		int differ = Integer.MAX_VALUE;
		for (int k = 0; k < nums.length; k++) {
			int i = k + 1, j = nums.length - 1;
			while (i < j) {
				int sum = nums[k] + nums[i] + nums[j];
				int diff = Math.abs(sum - target);
				if (diff < differ) {
					differ = diff;
					res = sum;
				}
				if (sum < target) {
					i++;
				} else if (sum == target) {
					return sum;
				} else {
					j--;
				}

			}
		}
		return res;
    }
 */