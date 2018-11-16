package Hard;

public class isMatch {
    //44. 通配符匹配
    //给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
    //
    //'?' 可以匹配任何单个字符。
    //'*' 可以匹配任意字符串（包括空字符串）。
    //两个字符串完全匹配才算匹配成功。
    //
    //说明:
    //
    //s 可能为空，且只包含从 a-z 的小写字母。
    //p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
    //示例 1:
    //
    //输入:
    //s = "aa"
    //p = "a"
    //输出: false
    //解释: "a" 无法匹配 "aa" 整个字符串。
    //示例 2:
    //
    //输入:
    //s = "aa"
    //p = "*"
    //输出: true
    //解释: '*' 可以匹配任意字符串。
    //示例 3:
    //
    //输入:
    //s = "cb"
    //p = "?a"
    //输出: false
    //解释: '?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
    //示例 4:
    //
    //输入:
    //s = "adceb"
    //p = "*a*b"
    //输出: true
    //解释: 第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".
    //示例 5:
    //
    //输入:
    //s = "acdcb"
    //p = "a*c?b"
    //输入: false

    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }

        boolean[][] memo = new boolean[s.length()][p.length()];
        boolean[][] visited = new boolean[s.length()][p.length()];
        return isMatchHelper(s, 0, p, 0, memo, visited);
    }

    private boolean isMatchHelper(String s, int sIndex,
                                  String p, int pIndex,
                                  boolean[][] memo,
                                  boolean[][] visited) {
        // 如果 p 从pIdex开始是空字符串了，那么 s 也必须从 sIndex 是空才能匹配上
        if (pIndex == p.length()) {
            return sIndex == s.length();
        }

        // 如果 s 从 sIndex 是空，那么p 必须全是 *
        if (sIndex == s.length()) {
            return allStar(p, pIndex);
        }

        if (visited[sIndex][pIndex]) {
            return memo[sIndex][pIndex];
        }

        char sChar = s.charAt(sIndex);
        char pChar = p.charAt(pIndex);
        boolean match;

        if (pChar == '*') {
            match = isMatchHelper(s, sIndex, p, pIndex + 1, memo, visited) ||
                    isMatchHelper(s, sIndex + 1, p, pIndex, memo, visited);
        } else {
            match = charMatch(sChar, pChar) &&
                    isMatchHelper(s, sIndex + 1, p, pIndex + 1, memo, visited);
        }

        visited[sIndex][pIndex] = true;
        memo[sIndex][pIndex] = match;
        return match;
    }

    private boolean charMatch(char sChar, char pChar) {
        return (sChar == pChar || pChar == '?');
    }

    private boolean allStar(String p, int pIndex) {
        for (int i = pIndex; i < p.length(); i++) {
            if (p.charAt(i) != '*') {
                return false;
            }
        }
        return true;
    }
}
