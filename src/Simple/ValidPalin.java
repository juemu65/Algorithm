package Simple;

public class ValidPalin {
    //125.验证回文串
    //给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
    //
    //说明：本题中，我们将空字符串定义为有效的回文串。

    public boolean isPalindrome(String s) {
        if(s == "")
            return true;
        char[] c = s.toCharArray();
        int low = 0;
        int high = c.length - 1;
        while(low < high){
            if(!((c[low] <= 57 && c[low] >= 48) || (c[low] <= 90 && c[low] >= 65) || (c[low] <= 122 && c[low] >= 97))){
                low++;
                continue;
            }
            if(!((c[high] <= 57 && c[high] >= 48) || (c[high] <= 90 && c[high] >= 65) || (c[high] <= 122 && c[high] >= 97)))             {
                high--;
                continue;
            }
            if(!(c[low] == c[high] || (c[low] <= 90 && c[low] >= 65 && c[low] + 32 == c[high]) || (c[high] <= 90 && c[high] >= 65 && c[high] + 32 == c[low])))
                return false;
            low++;
            high--;
        }
        return true;
    }


    /*
    680. 验证回文字符串 Ⅱ
    给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串

     public boolean validPalindrome(String s) {
        return validate(s, 0, s.length() - 1, 0, 1);
    }

    public boolean validate(String s, int i, int j, int delCount, int N) {
        if (delCount > N) return false; // N - times of deletion allowed.
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                delCount++;
                return validate(s, i, j - 1, delCount, N) || validate(s, i + 1, j, delCount, N);
            }
        }
        return true;
    }


     */
}
