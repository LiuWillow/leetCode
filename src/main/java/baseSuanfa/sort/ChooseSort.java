package baseSuanfa.sort;

import java.util.Arrays;

/**
 * @author lwl
 * @date 2019/4/3 17:00
 * @description 选择排序
 * 先找到数组中最小的元素，将其与第一个元素交换位子，然后在剩下的元素中找最小，与第二个交换，以此类推
 */
public class ChooseSort {
    public void sort(int[] nums){
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            int min = nums[i];
            int minIndex = i;
            for (int j = i + 1; j < length; j++) {
                if (min > nums[j]){
                    min = nums[j];
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{34,4,6,7,3,2,3,55,2,34,53};
        new ChooseSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}