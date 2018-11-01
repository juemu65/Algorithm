package Simple;


import java.util.*;

public class MajEle {
    //169.求众数
    public int majorityNumber(List<Integer> nums) {

        int currentMajor = 0;
        int count = 0;

        for(Integer num : nums) {
            if(count == 0) {
                currentMajor = num;
            }

            if(num == currentMajor) {
                count++;
            } else {
                count--;
            }
        }

        return currentMajor;
    }
}
