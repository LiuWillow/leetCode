package baseSuanfa;

import java.util.Arrays;

/**
 * author liuweilong
 * date 2019/9/24 14:41
 * desc
 */
public class MaoPaoSort {
    public void sort(int[] nums) {
        for (int i = nums.length; i > 0; i--) {
            for (int j = 0; j < i - 1; j++) {
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
