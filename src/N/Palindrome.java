package N;

public class Palindrome {
/*
* 5.最长回文子串
* 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000
*
* */
    public static void isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            System.out.print("False");
            return;
        }

        int rever = 0;
        while (x > rever) {
            rever = rever * 10 + x % 10;
            x /= 10;
        }
        if (x == rever || x == rever / 10) {
            System.out.print("True");
        } else {
            System.out.print("False");
        }
    }

}
