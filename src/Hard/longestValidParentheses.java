package Hard;

import java.util.*;

public class longestValidParentheses {
    //32. 最长有效括号
    //给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
    //
    //示例 1:
    //
    //输入: "(()"
    //输出: 2
    //解释: 最长有效括号子串为 "()"
    //示例 2:
    //
    //输入: ")()())"
    //输出: 4
    //解释: 最长有效括号子串为 "()()"

    public int longestValidParentheses(String s) {
        int res = 0, diff = 0;
        int memo[] = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                diff++;
            } else if (diff > 0) {
                memo[i] = memo[i - 1] + 2;
                if (i > memo[i]) {
                    memo[i] += memo[i - memo[i]];
                }
                if (memo[i] > res) {
                    res = memo[i];
                }
                diff--;
            }
        }
        return res;
    }
}
