package Simple;

public class ReverseInt {
//7.反转整数
    //给定一个 32 位有符号整数，将整数中的数字进行反转。

    public int reverse(int x) {
        long tmp = x; // 防止结果溢出
        long result = 0;
        while (tmp != 0) {
            result = result *10 + tmp % 10;
            tmp = tmp /10; }
        // 溢出判断
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE)
        {
            result =0; }
        return (int) result;
    }
}
