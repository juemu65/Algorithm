package N;

import java.util.ArrayList;
import java.util.List;

public class GeneratePar {
    //22.括号生成
    //给出 n 代表生成括号的对数，
    // 请你写出一个函数，
    // 使其能够生成所有可能的并且有效的括号组合。

    class Solution {
        List<String> res = new ArrayList<>();
        int n;

        void gen(int nleft, int nright, String cur) {
            if (nleft == n && nright == n) {
                res.add(cur);
                return;
            }

            if (nleft < n) {
                gen(nleft + 1, nright, cur + "(");
            }

            if (nright < nleft) {
                gen(nleft, nright + 1, cur + ")");
            }
        }

        public List<String> generateParenthesis(int nn) {
            n = nn;
            gen(0, 0, "");
            return res;
        }
    }
}
