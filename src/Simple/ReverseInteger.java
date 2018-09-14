package Simple;

public class ReverseInteger {
    public static int reverseInteger(int n) {
        int z = 0;

        while (n != 0) {
            int temp = z * 10 + n % 10;
            n = n / 10;
            if (temp / 10 != z) {
                z = 0;
                break;
            }
            z = temp;
        }
        return z;
    }
}
