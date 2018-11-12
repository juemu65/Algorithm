package N;

import java.util.*;

public class nextPermutation {
    //31. 下一个排列
    //实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
    //
    //如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
    //
    //必须原地修改，只允许使用额外常数空间。
    //
    //以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
    //1,2,3 → 1,3,2
    //3,2,1 → 1,2,3
    //1,1,5 → 1,5,1

    public void nextPermutation(int[] nums) {
        int len=nums.length;
        boolean done=false;
        if(len>1){
            int i,j;
            int minlar=0;
            for(i=len-2;i>=0;i--){
                if(nums[i]<nums[i+1]){
                    for(j=len-1;j>i;j--){
                        if(nums[j]>nums[i]){
                            nums[i]+=nums[j];
                            nums[j]=nums[i]-nums[j];
                            nums[i]-=nums[j];
                            Arrays.sort(nums,i+1,len);
                            done=true;
                            break;
                        }
                    }
                }
                if(done){
                    break;
                }
            }
            if(done==false){
                Arrays.sort(nums);
            }
        }
        return;
    }

}
