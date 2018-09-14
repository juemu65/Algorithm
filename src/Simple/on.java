package Simple;


import static Simple.TwoSum.twoSum;

public class on {
    public static void main(String[] args) {
        //two sum
        int[] sum1 = {1,3, 7,6,2, 8, 15};
        int[] result = twoSum(sum1, 9);
        for(Integer i:result){
            System.out.print(i+" ");
        }

    }


}

