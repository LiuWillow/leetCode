package baseSuanfa.sort.n;

import java.util.Arrays;

/**
 * author liuweilong
 * date 2019/11/2 18:04
 * desc 计数排序，适用于目标在某一个数字范围内，将数字范围作为计数数组的index，记录每个数字出现的次数，然后将计数数组翻译成排序后的数组
 */
public class CountingSort {
    public int[] test(int[] nums) {
        // 先找到最大值，确定计数数组长度 max+1
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(nums[i], max);
        }

        // 创建计数数组，遍历nums，计数
        int[] countArray = new int[max + 1];
        for (int num : nums) {
            countArray[num]++;
        }

        int[] result = new int[nums.length];
        //创建新数组，根据计数数组把结果赋值给新数组
        int j = 0;
        for (int i = 0; i < countArray.length; i++) {
            int count = countArray[i];
            if (count != 0) {
                for (int k = 0; k < count; k++) {
                    result[j++] = i;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 6, 3, 4, 2, 3, 3, 4, 1, 1, 1};
        int[] result = new CountingSort().test(nums);
        System.out.println(Arrays.toString(result));
    }
}
