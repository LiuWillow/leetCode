import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author liuweilong
 * @date 2021/5/11
 * @description 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 * <p>
 * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 输出：[[1,5],[6,9]]
 * 示例 2：
 * <p>
 * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 输出：[[1,2],[3,10],[12,16]]
 * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 * 示例 3：
 * <p>
 * 输入：intervals = [], newInterval = [5,7]
 * 输出：[[5,7]]
 * 示例 4：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,3]
 * 输出：[[1,5]]
 * 示例 5：
 * <p>
 * 输入：intervals = [[1,5]], newInterval = [2,7]
 * 输出：[[1,7]]
 *  
 */
public class Q57_insert {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> resultList = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        for (int[] interval : intervals) {
            int intervalLeft = interval[0];
            int intervalRight = interval[1];
            if (intervalLeft > right) {
                if (!placed) {
                    //在区间的左边，完全无交集
                    placed = true;
                    resultList.add(newInterval);
                }
                resultList.add(interval);
            } else if (intervalRight < left) {
                //在区间右侧，没有交集
                resultList.add(interval);
            } else {
                //有交集，更新left, right
                left = Math.min(intervalLeft, left);
                right = Math.max(intervalRight, right);
            }
        }

        if (!placed) {
            resultList.add(newInterval);
        }

        int[][] result = new int[resultList.size()][2];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
    }
}
