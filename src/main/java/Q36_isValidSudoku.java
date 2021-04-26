import java.util.HashMap;
import java.util.Map;

/**
 * @author liuweilong
 * @date 2021/3/31
 * @description 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * <p>
 * 上图是一个部分填充的有效的数独。
 * <p>
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 */
public class Q36_isValidSudoku {
    private static final char BLANK = '.';

    //row -> 数组下标表示数字的值，是否已填充
    private static final Map<Integer, boolean[]> ROW_2_NUM_MAP = new HashMap<>(9);
    //
    private static final Map<Integer, boolean[]> COL_2_NUM_MAP = new HashMap<>(9);
    //第一个格子key为0
    private static final Map<Integer, boolean[]> CELL_2_NUM_MAP = new HashMap<>(9);

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 10; i++) {
            ROW_2_NUM_MAP.put(i, new boolean[10]);
            COL_2_NUM_MAP.put(i, new boolean[10]);
            CELL_2_NUM_MAP.put(i, new boolean[10]);
        }

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                char c = board[row][col];
                if (BLANK == c) {
                    continue;
                }
                int n = c - '0';
                //行
                boolean[] rowArray = ROW_2_NUM_MAP.get(row);
                boolean rowExist = rowArray[n];
                if (rowExist) {
                    return false;
                } else {
                    rowArray[n] = true;
                }

                //列
                boolean[] colArray = COL_2_NUM_MAP.get(col);
                boolean colExist = colArray[n];
                if (colExist) {
                    return false;
                } else {
                    colArray[n] = true;
                }

                //小格子
                int cell = getCell(row, col);
                boolean[] cellArray = CELL_2_NUM_MAP.get(cell);

                boolean cellExist = cellArray[n];
                if (cellExist) {
                    return false;
                } else {
                    cellArray[n] = true;
                }
            }
        }

        return true;
    }

    public int getCell(int row, int col) {
        return (row / 3) * 3 + col / 3;
    }

    public static void main(String[] args) {
        Q36_isValidSudoku test = new Q36_isValidSudoku();
        char[][] sss = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        assert test.isValidSudoku(sss);
    }
}
