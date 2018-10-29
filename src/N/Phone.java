package N;

import java.util.*;

public class Phone {

    //电话号码字母组合
    //给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
    //
    //给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。

    private void dfs(int x, int l, String str, String digits, String phone[], List<String> ans) {
        if (x == l) {
            ans.add(str);
            return;
        }
        int d = digits.charAt(x) - '0';
        for (char c : phone[d].toCharArray()) {
            dfs(x + 1, l, str + c, digits, phone, ans);
        }
    }

    public List<String> letterCombinations(String digits) {
        // write your code here
        String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }

        dfs(0, digits.length(), "", digits, phone, ans);
        return ans;
    }
}
