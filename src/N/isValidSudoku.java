package N;

import java.util.*;

public class isValidSudoku {

    //36. 有效的数独
    //判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
    //
    //数字 1-9 在每一行只能出现一次。
    //数字 1-9 在每一列只能出现一次。
    //数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。

    public boolean isValidSudoku(char[][] board) {
        boolean[] visited = new boolean[9];

        // row
        for(int i = 0; i<9; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j<9; j++){
                if(!process(visited, board[i][j]))
                    return false;
            }
        }

        //col
        for(int i = 0; i<9; i++){
            Arrays.fill(visited, false);
            for(int j = 0; j<9; j++){
                if(!process(visited, board[j][i]))
                    return false;
            }
        }

        // sub matrix
        for(int i = 0; i<9; i+= 3){
            for(int j = 0; j<9; j+= 3){
                Arrays.fill(visited, false);
                for(int k = 0; k<9; k++){
                    if(!process(visited, board[i + k/3][ j + k%3]))
                        return false;
                }
            }
        }
        return true;

    }

    private boolean process(boolean[] visited, char digit){
        if(digit == '.'){
            return true;
        }

        int num = digit - '0';
        if ( num < 1 || num > 9 || visited[num-1]){
            return false;
        }

        visited[num-1] = true;
        return true;
    }
}
