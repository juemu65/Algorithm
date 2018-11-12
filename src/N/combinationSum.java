package N;


import java.util.*;

public class combinationSum {
    //39. 组合总和
    //给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
    //
    //candidates 中的数字可以无限制重复被选取。
    //
    //说明：
    //
    //所有数字（包括 target）都是正整数。
    //解集不能包含重复的组合。
    //示例 1:
    //
    //输入: candidates = [2,3,6,7], target = 7,
    //所求解集为:
    //[
    //  [7],
    //  [2,2,3]
    //]
    //示例 2:
    //
    //输入: candidates = [2,3,5], target = 8,
    //所求解集为:
    //[
    //  [2,2,2,2],
    //  [2,3,3],
    //  [3,5]
    //]

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        Arrays.sort(candidates); //[2,2,3,6,7]
        helper(candidates, target, res, 0, new ArrayList<Integer>());
        return res;
    }

    private void helper(int[] candidates, int target, List<List<Integer>> res, int startIndex, List<Integer> path) {
        if (target == 0) {// target == 0针对当前找不到组合和的情况不会成为递归的出口，程序会一直进行下去
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) { //remove duplicates
                continue;
            }
            if (candidates[i] > target) {
                return; //这个看似是一个剪枝，实际上也是一个递归的出口，说明再往下进行也找不到组合和了，必须停止程序
            }
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], res, i, path);
            path.remove(path.size() - 1);
        }
    }
}


/*

//40. 组合总和 II
//题目描述提示帮助提交记录社区讨论阅读解答
//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
//candidates 中的每个数字在每个组合中只能使用一次。
//
//说明：
//
//所有数字（包括目标数）都是正整数。
//解集不能包含重复的组合。
//示例 1:
//
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
//示例 2:
//
//输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//]


public List<List<Integer>> combinationSum2(int[] candidates,
            int target) {
        List<List<Integer>> results = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return results;
        }

        Arrays.sort(candidates);
        List<Integer> combination = new ArrayList<Integer>();
        helper(candidates, 0, combination, target, results);

        return results;
    }

    private void helper(int[] candidates,
                        int startIndex,
                        List<Integer> combination,
                        int target,
                        List<List<Integer>> results) {
        if (target == 0) {
            results.add(new ArrayList<Integer>(combination));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (i != startIndex && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (target < candidates[i]) {
                break;
            }
            combination.add(candidates[i]);
            helper(candidates, i + 1, combination, target - candidates[i], results);
            combination.remove(combination.size() - 1);
        }
    }

 */