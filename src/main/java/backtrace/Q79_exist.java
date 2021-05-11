package backtrace;

/**
 * @author liuweilong
 * @date 2021/5/11
 * @description 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 */
public class Q79_exist {
    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if (dfs(board, word, 0, row, col, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int currentCharIdx, int row, int col, boolean[][] visited) {
        char currentBoardChar = board[row][col];
        char currentTargetChar = word.charAt(currentCharIdx);
        if (!(currentTargetChar == currentBoardChar)) {
            return false;
        }
        if (currentCharIdx == word.length() - 1) {
            return true;
        }
        visited[row][col] = true;
        int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length && !visited[nextRow][nextCol]) {
                if (dfs(board, word, currentCharIdx + 1, nextRow, nextCol, visited)) {
                    return true;
                }
            }
        }

        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        char[][] board2 = new char[][]{
                {'E'}
        };
        System.out.println(new Q79_exist().exist(board, "E"));
        System.out.println(new Q79_exist().exist(board, "EE"));
        System.out.println(new Q79_exist().exist(board, "FBD"));
    }
}
