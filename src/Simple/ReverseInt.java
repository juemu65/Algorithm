package Simple;

public class ReverseInt {
//反转整数
    //给定一个 32 位有符号整数，将整数中的数字进行反转。

    public int reverseInteger(int n) {
        int reversed_n = 0;

        while (n != 0) {
            int temp = reversed_n * 10 + n % 10;
            n = n / 10;
            if (temp / 10 != reversed_n) {
                reversed_n = 0;
                break;
            }
            reversed_n = temp;
        }
        return reversed_n;
    }
}
