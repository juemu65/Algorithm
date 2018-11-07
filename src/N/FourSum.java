package N;
import java.util.*;

public class FourSum {
//18.四数之和

//给定一个包含 n 个整数的数组 nums 和一个目标值 target，
// 判断 nums 中是否存在四个元素 a，b，c 和 d ，
// 使得 a + b + c + d 的值与 target 相等？
// 找出所有满足条件且不重复的四元组。



    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len=nums.length;
        if(len<4){return result;}
        Arrays.sort(nums);
        for(int i=0;i<len-3;i++){
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for(int j=i+1;j<len-2;j++){
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target) break;
                if(nums[i]+nums[j]+nums[len-2]+nums[len-1]<target) continue;
                int low=j+1;
                int high=len-1;
                while(low<high){
                    if(nums[i]+nums[j]+nums[low]+nums[high]==target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[low],nums[high]));
                        while(low<high&&nums[high]==nums[high-1]){high--;}
                        while(low<high&&nums[low]==nums[low+1]){low++;}
                        low++;
                        high--;
                    }else if(nums[i]+nums[j]+nums[low]+nums[high]>target){
                        high--;
                    }else if(nums[i]+nums[j]+nums[low]+nums[high]<target){
                        low++;
                    }
                }
            }
        }
        return result;
    }
}
