package util;

/**
 * @author liuweilong
 * @date 2021/10/21 4:31 下午
 * @description
 */

public class ArraysUtils {
    public static void exchange(int src, int target, int[] nums) {
        int temp = nums[src];
        nums[src] = nums[target];
        nums[target] = temp;
    }
}
