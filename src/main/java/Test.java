import lianbiao.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author liuweilong
 * @date 2021/11/8 2:41 下午
 * @description
 */

public class Test {
    public boolean exist(char[][] board, String word) {
        boolean[][] via = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                boolean result = backTrace(via, board, word, 0, row, col);
                if (result) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrace(boolean[][] via, char[][] board, String word, int cur, int row, int col) {
        if (cur == word.length()) {
            return true;
        }
        if (row < 0 || row > board.length - 1 || col < 0 || col > board[0].length - 1) {
            return false;
        }
        if (via[row][col]) {
            return false;
        }
        if (board[row][col] != word.charAt(cur)) {
            return false;
        }

        //走到这里，说明当前的点匹配上了
        via[row][col] = true;
        //上 row - 1, col
        //下 row + 1, col
        //左 row, col - 1
        //右 row, col + 1
        cur++;
        boolean exist = backTrace(via, board, word, cur, row - 1, col)
                || backTrace(via, board, word, cur, row + 1, col)
                || backTrace(via, board, word, cur, row, col - 1)
                || backTrace(via, board, word, cur, row, col + 1);
        via[row][col] = false;
        return exist;
    }


    public static void main(String[] args) {
        System.out.println();
    }
}