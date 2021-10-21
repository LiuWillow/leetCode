package baseSuanfa.sort.n2;

import java.util.Arrays;

/**
 * author liuweilong
 * date 2019/9/24 14:41
 * desc 冒泡排序，与相邻的数字相比，大的往右移，最后一个一定是最大的
 */
public class MaoPaoSort {
    public void sort(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] x = new int[]{3, 2};
        int[] y = new int[]{3};
        int[] z = new int[]{3, 5, 2, 3, 0};
        MaoPaoSort maoPaoSort = new MaoPaoSort();
        maoPaoSort.sort(x);
        maoPaoSort.sort(y);
        maoPaoSort.sort(z);

        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(y));
        System.out.println(Arrays.toString(z));
    }
}
