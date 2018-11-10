package Simple;

public class TheSingle {
    //136.只出现一次的数字
    // 给出2*n + 1 个的数字，除其中一个数字之外其他每个数字均出现两次，找到这个数字。
    //该题只规定出线一个单独数字

    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int rst = 0;
        for (int i = 0; i < nums.length; i++) {
            rst ^= nums[i];
        }
        return rst;
    }
    /*
    137.只出现一次的数字II
    给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素

    public int singleNumberII(int[]  nums) {
        int ones = 0;               //记录只出现过1次的bits
        int twos = 0;               //记录只出现过2次的bits
        int threes;
        for(int i = 0; i < nums.length; i++){
            int t = nums[i];
            twos |= ones&t;         //要在更新ones前面更新twos
            ones ^= t;
            threes = ones&twos;      //ones和twos中都为1即出现了3次
            ones &= ~threes;       //抹去出现了3次的bits
            twos &= ~threes;
        }
            return ones;
    }


    260.只出现一次的数字II
    给定一个整数数组 nums，其中恰好有两个元素只出现一次，
    其余所有元素均出现两次。 找出只出现一次的那两个元素

    public List<Integer> singleNumberIII(int[]  nums) {
        int xor = 0;
        for (int i = 0; i <  nums.length; i++) {
            xor ^=  nums[i];
        }

        int l numsstBit = xor - (xor & (xor - 1));
        int group0 = 0, group1 = 0;
        for (int i = 0; i <  nums.length; i++) {
            if ((l numsstBit &  nums[i]) == 0) {
                group0 ^=  nums[i];
            } else {
                group1 ^=  nums[i];
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(group0);
        result.add(group1);
        return result;
    }



    */
}
