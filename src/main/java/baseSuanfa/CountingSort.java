package baseSuanfa;

import java.util.Arrays;

/**
 * author liuweilong
 * date 2019/11/2 18:04
 * desc 计数排序
 */
public class CountingSort {
    public int[] sort(int[] nums) {
        //先遍历一遍，拿到最大值和最小值
        int max = nums[0];
        int min = max;
        for (int num : nums) {
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        //根据最大值和最小值分桶
        int[] buckets = new int[max - min + 1];
        //遍历数组，将得分人数统计在每个桶中
        for (int num : nums) {
            buckets[num - min]++;
        }
        //累加桶数据
        for (int i = 1; i < buckets.length; i++) {
            buckets[i] = buckets[i] + buckets[i - 1];
        }
        //再次遍历数组，获取对应下标，对应数字减一
        int[] result = new int[nums.length];
        for (int num : nums) {
            int rank = buckets[num - min];
            if (rank > 0) {
                result[--buckets[num - min]] = num;
                continue;
            }
            result[rank] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 4, 6, 3, 4, 2, 3, 3, 4, 1, 1, 1};
        int[] result = new CountingSort().sort(nums);
        System.out.println(Arrays.toString(result));
    }
}
