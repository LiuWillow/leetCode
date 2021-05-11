package binary;

/**
 * @author liuweilong
 * @date 2021/5/11
 * @description 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 */
public class Q74_searchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = binarySearchRow(matrix, target);
        if (row == -1) {
            return false;
        }
        int result = binarySearch(matrix[row], target);
        return result != -1;
    }

    private int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                left++;
            } else {
                right--;
            }
        }
        return -1;
    }

    private int binarySearchRow(int[][] matrix, int target) {
        int left = 0;
        int right = matrix.length - 1;
        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (target == matrix[mid][0]) {
                return mid;
            } else if (target > matrix[mid][0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right;
    }

    /**
     * 一次二分
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrixOnce(int[][] matrix, int target) {
        int left = 0;
        int maxRow = matrix.length;
        int maxCol = matrix[0].length;
        int right = maxRow * maxCol - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int tryNum = matrix[mid / maxCol][mid % maxCol];
            if (tryNum == target) {
                return true;
            } else if (tryNum > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Q74_searchMatrix().searchMatrixOnce(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 7) + " : true");
        System.out.println(new Q74_searchMatrix().searchMatrixOnce(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 1) + " : true");
        System.out.println(new Q74_searchMatrix().searchMatrixOnce(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 0) + " : false");
        System.out.println(new Q74_searchMatrix().searchMatrixOnce(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 2) + " : false");
        System.out.println(new Q74_searchMatrix().searchMatrixOnce(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 8) + " : false");
        System.out.println(new Q74_searchMatrix().searchMatrixOnce(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 10) + " : true");
        System.out.println(new Q74_searchMatrix().searchMatrixOnce(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 16) + " : true");
        System.out.println(new Q74_searchMatrix().searchMatrixOnce(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 60) + " : true");
        System.out.println(new Q74_searchMatrix().searchMatrixOnce(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 23) + " : true");
        System.out.println(new Q74_searchMatrix().searchMatrixOnce(new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}}, 70) + " : false");
    }
}
