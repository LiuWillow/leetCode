package baseSuanfa;

import java.util.Arrays;

/**
 * @author lwl
 * @date 2019/4/3 17:12
 * @description 希尔排序
 * 比较一定增量间隔的数字，这样一次就能移动较远间隔，一般初次增量为数组一半，之后每次减半，直到增量为0
 */
public class HillSort {
    public void sort(int[] nums){
        int length = nums.length;
        int gap = length / 3 + 1;
        while (gap >= 1){
            for (int j = 0; j < length - gap; j++) {
                for (int i = j; i < length; i += gap) {
                    if (i + gap < length && nums[i] > nums[i + gap]){
                        int temp = nums[i];
                        nums[i] = nums[i + gap];
                        nums[i + gap] = temp;
                    }
                }
            }
            gap = gap / 2;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{34,4,6,7,3,2,3,55,2,34,53};
        new HillSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}