package Simple;

public class Palindrome {

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
