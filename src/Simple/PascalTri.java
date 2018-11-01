package Simple;
import java.util.*;
public class PascalTri {
    //118.杨辉三角

    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> rst = new ArrayList<ArrayList<Integer>>();
        if (numRows == 0) {
            return rst;
        }

        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(0, 1);
        rst.add(first);

        for (int i = 1; i < numRows; i++) {
            ArrayList<Integer> tmp = new ArrayList<Integer>(i + 1);
            for (int j = 0; j < i + 1; j++){
                tmp.add(-1);
            }
            ArrayList<Integer> prev = rst.get(i - 1);
            tmp.set(0, prev.get(0));
            tmp.set(i, prev.get(i - 1));
            for (int j = 1; j < i; j++){
                tmp.set(j, prev.get(j - 1)+prev.get(j));
            }
            rst.add(tmp);
        }
        return rst;
    }

    // 119.杨辉三角II

    // 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行
    //
    // public ArrayList<Integer> getRow(int rowIndex) {
    //        ArrayList<Integer> rst = new ArrayList<Integer>();
    //        rowIndex += 1;
    //        if (rowIndex == 0) {
    //            return rst;
    //        }
    //
    //        rst.add(1);
    //        for (int i = 1; i < rowIndex; i++) {
    //            ArrayList<Integer> tmp = new ArrayList<Integer>(i+1);
    //            for (int j = 0; j < i + 1; j++) {
    //                tmp.add(-1);
    //            }
    //            tmp.set(0, rst.get(0));
    //            tmp.set(i, rst.get(i - 1));
    //            for (int j = 1; j < i; j++) {
    //                tmp.set(j, rst.get(j - 1) + rst.get(j));
    //            }
    //            rst = tmp;
    //        }
    //        return rst;
    //    }
}
