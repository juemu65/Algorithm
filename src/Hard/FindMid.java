package Hard;

public class FindMid {
//4.两个排序数组的中位数

//给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
//
//    请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
//
//    你可以假设 nums1 和 nums2 不同时为空。


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        if (length1 == 0) {
            if (length2 % 2 == 1) {
                double res = nums2[length2 / 2];
                return res;
            } else {
                double a=nums2[length2 / 2 - 1];
                double b=nums2[length2 / 2];
                double res = (a+b) / 2;
                return res;
            }
        }
        if (length2 == 0) {
            if (length1 % 2 == 1) {
                double res = nums1[length1 / 2];
                return res;
            } else {
                double a=nums1[length1 / 2 - 1];
                double b=nums1[length1 / 2];
                double res = (a+b) / 2;
                return res;
            }
        }
        int[] total = new int[length1 + length2];
        int index = 0;
        boolean isAdd = true;
        int i = 0;
        int j = 0;
        boolean b1 = true;
        boolean b2 = true;
        while (b1 || b2) {
            if (nums1[i] > nums2[j]) {
                if (b2) {
                    total[index] = nums2[j];
                }
                else {
                    total[index] = nums1[i];
                }
                if (j == length2 - 1 && b2) {
                    b2 = false;
                    index++;
                    continue;
                }
                if (b2) {
                    j++;
                } else {
                    i++;
                }
            } else {
                if (b1) {
                    total[index] = nums1[i];
                } else {
                    total[index] = nums2[j];
                }
                if (i == length1 - 1 && b1) {
                    b1 = false;
                    index++;
                    continue;
                }
                if (b1) {
                    i++;
                } else {
                    j++;
                }
            }
            index++;
            if (index >= ((length1 + length2) / 2 + 1)) {
                break;
            }
        }
        if ((length1 + length2) % 2 == 1) {
            double res = total[(length1 + length2) / 2];
            return res;
        } else {
            double a = total[(length1 + length2) / 2 - 1];
            double b = total[(length1 + length2) / 2];
            double res = (a + b) / 2;
            return res;
        }
    }
}
