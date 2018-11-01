package Hard;

public class ReverseInteger {
    /*
    *4.两个排序数组的中位数
    *给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
    * */
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
