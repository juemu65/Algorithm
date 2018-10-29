package Simple;

public class ClimStairs {
    //爬楼梯
    //假设你正在爬楼梯，需要n步你才能到达顶部。
    // 但每次你只能爬一步或者两步，你能有多少种不同的方法爬到楼顶部？
    int[] result = null;

    void f(int X) {
        if (result[X] != -1) return;
        if (X == 0 || X == 1) {
            result[X] = 1;
            return;
        }

        f(X - 1);
        f(X - 2);
        result[X] = result[X - 1] + result[X - 2];
    }

    public int climbStairs(int n) {
        if (n == 0) {
            return 0;
        }

        result  = new int[n + 1];
        for (int i = 0; i <= n; ++i) {
            result[i] = -1;
        }

        f(n);
        return result[n];
    }

}
