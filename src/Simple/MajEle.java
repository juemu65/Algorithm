package Simple;


import java.util.*;

public class MajEle {
    //169.求众数
    public int majorityNumber(int []nums) {

        int count = 0;
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(res==nums[i]) {
                count++;
            }else {
                count--;
                if(count==0) {
                    res=nums[i];
                    count++;
                }
            }
        }
        return res;
    }
}
