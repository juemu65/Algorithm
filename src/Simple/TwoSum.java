package Simple;

import java.util.HashMap;

public class TwoSum {

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
