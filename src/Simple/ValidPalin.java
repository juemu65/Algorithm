package Simple;

public class ValidPalin {
    //验证回文串
    //给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    //
    //说明：本题中，我们将空字符串定义为有效的回文串。

    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }

        int front = 0;
        int end = s.length() - 1;
        while (front < end) {
            while (front < s.length() && !isvalid(s.charAt(front))){ // nead to check range of a/b
                front++;
            }

            if (front == s.length()) { // for empty string “.,,,”
                return true;
            }

            while (end >= 0 && ! isvalid(s.charAt(end))) { // same here, need to check border of a,b
                end--;
            }

            if (Character.toLowerCase(s.charAt(front)) != Character.toLowerCase(s.charAt(end))) {
                break;
            } else {
                front++;
                end--;
            }
        }

        return end <= front;
    }

    private boolean isvalid (char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }
}
