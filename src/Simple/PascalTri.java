package Simple;
import java.util.*;
public class PascalTri {
    //118.杨辉三角

    List<List<Integer>> result;

    public List<List<Integer>> generate(int numRows) {
        result = new ArrayList<>();
        if(numRows <= 0){
            return result;
        }
        List<Integer> record = new ArrayList<>();
        record.add(1);
        helper(numRows - 1, record);
        return result;
    }

    private void helper(int count, List<Integer> record){
        result.add(new ArrayList<Integer>(record));
        if(count == 0){
            return;
        }
        List<Integer> list = new ArrayList<>();
        int num = 0;
        record.add(0);
        for(int i = 0; i < record.size(); i++){
            int sum = num + record.get(i);
            list.add(sum);
            num = record.get(i);
        }
        helper(count - 1, list);
    }

    // 119.杨辉三角II

    // 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行
    /*
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 0)
            return list;

        for (int i = 0;i <= rowIndex;i++) {
            list.add(0);
        }

        list.set(0, 1);
        for (int i = 1;i <= rowIndex;i++) {
            for (int j = i;j >= 0;j--) {
                list.set(j, (j - 1 < 0? 0 : list.get(j - 1)) + list.get(j));
            }
        }

        return list;
    }

     */
}
