package Simple;

public class LengthOflast {
    //最后一个单词长度
    //给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
    //
    //如果不存在最后一个单词，请返回 0 。
    //
    //说明：一个单词是指由字母组成，但不包含任何空格的字符串。

    public int lengthOfLastWord(String s) {
        int length = 0;
        char[] chars = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (length == 0) {
                if (chars[i] == ' ') {
                    continue;
                } else {
                    length++;
                }
            } else {
                if (chars[i] == ' ') {
                    break;
                } else {
                    length++;
                }
            }
        }

        return length;
    }
}
