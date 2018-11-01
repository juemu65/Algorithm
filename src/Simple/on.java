package Simple;

import static N.Palindrome.isPalindrome;
import static Hard.ReverseInteger.reverseInteger;
import static Simple.TwoSum.twoSum;

public class on {
    public static void main(String[] args) {
        //two sum
        int[] sum1 = {1, 3, 7, 6, 2, 8, 15};
        int[] result = twoSum(sum1, 9);
        for (Integer i : result) {
            System.out.print(i + " ");
        }
        System.out.print("\n");
        int n = reverseInteger(1320);

        System.out.print(n + "\n");

        isPalindrome(11211);

        System.out.print("\n");
    }


}

