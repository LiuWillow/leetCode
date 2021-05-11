/**
 * @author liuweilong
 * @date 2021/5/11
 * @description 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 */
public class Q70_setZeroes {
    public void setZeroes(int[][] matrix) {
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;

        boolean firstRow0Flag = false;
        boolean firstCol0Flag = false;
        for (int i : matrix[0]) {
            if (i == 0) {
                firstRow0Flag = true;
                break;
            }
        }

        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                firstCol0Flag = true;
                break;
            }
        }

        for (int row = 1; row < maxRow; row++) {
            for (int col = 1; col < maxCol; col++) {
                if (matrix[row][col] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = 1; row < maxRow; row++) {
            for (int col = 1; col < maxCol; col++) {
                if (matrix[row][0] == 0 || matrix[0][col] == 0) {
                    matrix[row][col] = 0;
                }
            }
        }

        if (firstCol0Flag) {
            for (int row = 0; row < maxRow; row++) {
                matrix[row][0] = 0;
            }
        }

        if (firstRow0Flag) {
            for (int col = 0; col < maxCol; col++) {
                matrix[0][col] = 0;
            }
        }
    }
}
