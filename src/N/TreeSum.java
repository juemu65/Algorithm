package N;

import java.util.*;

public class TreeSum {
//三数之和
//给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
//
//注意：答案中不可以包含重复的三元组。
//
//例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
//
//满足要求的三元组集合为：
//[
//  [-1, 0, 1],
//  [-1, -1, 2]
//]

    List<List<Integer>> results = new ArrayList<>();

    // This is soring results using 1st number as 1st key, 2nd number as 2nd key...
    class ListComparator<T extends Comparable<T>> implements Comparator<List<Integer>> {
        @Override
        public int compare(List<Integer> a, List<Integer> b) {
            for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
                int c = a.get(i).compareTo(b.get(i));
                if (c != 0) {
                    return c;
                }
            }
            return Integer.compare(a.size(), b.size());
        }
    }

    public List<List<Integer>> threeSum(int[] A) {
        if (A == null || A.length < 3) {
            return results;
        }

        Arrays.sort(A);
        // enumerate c, the maximum element
        int i;
        int n = A.length;
        for (i = 2; i < n; ++i) {
            // c is always the last in a bunch of duplicates
            if (i + 1 < n && A[i + 1] == A[i]) {
                continue;
            }

            // want to find all pairs of A[j]+A[k]=-A[i], such that
            // j < k < i
            twoSum(A, i - 1, -A[i]);
        }

        Collections.sort(results, new ListComparator<>());

        return results;
    }

    // find all unique pairs such that A[i]+A[j]=S, and i < j <= right
    private void twoSum(int[] A, int right, int S) {
        int i, j;
        j = right;
        for (i = 0; i <= right; ++i) {
            // A[i] must be the first in its duplicates
            if (i > 0 && A[i] == A[i - 1]) {
                continue;
            }

            while (j > i && A[j] > S - A[i]) {
                --j;
            }

            if (i >= j) {
                break;
            }

            if (A[i] + A[j] == S) {
                List<Integer> t = new ArrayList<>();
                t.add(A[i]);
                t.add(A[j]);
                t.add(-S); // t.add(A[right+1])
                results.add(t);
            }
        }
    }
}


/*Nearly Three Sum    最接近的三数之和
//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
//
//例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.
//
//与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

public int threeSumClosest(int[] numbers, int target) {
        if (numbers == null || numbers.length < 3) {
            return -1;
        }

        Arrays.sort(numbers);
        int bestSum = numbers[0] + numbers[1] + numbers[2];
        for (int i = 0; i < numbers.length; i++) {
            int start = i + 1, end = numbers.length - 1;
            while (start < end) {
                int sum = numbers[i] + numbers[start] + numbers[end];
                if (Math.abs(target - sum) < Math.abs(target - bestSum)) {
                    bestSum = sum;
                }
                if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        return bestSum;
    }
 */