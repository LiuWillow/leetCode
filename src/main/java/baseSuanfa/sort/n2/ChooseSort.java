package baseSuanfa.sort.n2;

import java.util.Arrays;

/**
 * @author lwl
 * @date 2019/4/3 17:00
 * @description 选择排序
 * 先找到数组中最小的元素，将其与第一个元素交换位子，然后在剩下的元素中找最小，与第二个交换，以此类推
 */
public class ChooseSort {
    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < min) {
                    minIndex = j;
                    min = nums[j];
                }
            }
            nums[minIndex] = nums[i];
            nums[i] = min;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{34,4,6,7,3,2,3,55,2,34,53};
        new ChooseSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}