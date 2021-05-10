/**
 * @author liuweilong
 * @date 2021/5/10
 * @description 给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
 * <p>
 * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[7,4,1],[8,5,2],[9,6,3]]
 */
public class Q48_rotate {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int maxLevel = length / 2;
        for (int level = 0; level < maxLevel; level++) {
            //掐头去尾
            for (int idx = level; idx < length - level - 1; idx++) {
                rotate(matrix, level, idx, length);
            }
        }
    }

    //旋转第level层的第一行为参照的第idx个元素，idx小于matrix.length
    private void rotate(int[][] matrix, int level, int idx, int length) {
        int row = level;
        int col = idx;
        int temp = matrix[row][col];
        matrix[row][col] = matrix[length - col - 1][row];
        matrix[length - col - 1][row] = matrix[length - row - 1][length - col - 1];
        matrix[length - row - 1][length - col - 1] = matrix[col][length - row - 1];
        matrix[col][length - row - 1] = temp;
    }
}
