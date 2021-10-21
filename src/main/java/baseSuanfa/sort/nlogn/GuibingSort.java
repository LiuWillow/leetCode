package baseSuanfa.sort.nlogn;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lwl
 * @date 2019/4/3 17:41
 * @description 两个合成一个，需要将数组复制到新的数组中，临时数组作为辅助数组记录结果给原来的数组赋值
 */
public class GuibingSort {
    public void testSort(int[] nums) {
        // 定义划分函数 lo, hi, nums，划分里头包括把数组拆分两份，然后将两份合并
        // 定义合并函数 lo, hi, nums
        testSort(0, nums.length - 1, nums, new int[nums.length]);
    }

    public void testSort(int lo, int hi, int[] nums, int[] copyResult) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        testSort(lo, mid, nums, copyResult);
        testSort(mid + 1, hi, nums, copyResult);
        testMerge(lo, hi, mid, nums, copyResult);
    }

    public void testMerge(int lo, int hi, int mid, int[] nums, int[] copyResult) {
        System.arraycopy(nums, lo, copyResult, lo, hi - lo + 1);
        int tR = mid + 1;
        int tL = lo;
        for (int i = lo; i < hi + 1; i++) {
            if (tL > mid) {
                nums[i] = copyResult[tR++];
            } else if (tR > hi) {
                nums[i] = copyResult[tL++];
            } else if (copyResult[tL] > copyResult[tR]) {
                nums[i] = copyResult[tR++];
            } else {
                nums[i] = copyResult[tL++];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{34, 4, 6, 7, 3, 2, 3, 55, 2, 34, 53};
        new GuibingSort().sortDiedai(nums);
        System.out.println(Arrays.toString(nums));
    }


    //迭代，即从递归的结束条件开始进行操作，从2到4，然后处理边界
    public void sortDiedai(int[] nums) {
        int[] copyResult = new int[nums.length];
        int step = 2;
        int lo = 0;
        while (step <= nums.length) {
            while (lo < copyResult.length - step - 1) {
                int hi = lo + step - 1;
                int mid = lo + (hi - lo) / 2;
                testMerge(lo, hi, mid, nums, copyResult);
                lo = hi + 1;
            }

            if (lo - step <= nums.length - 1) {
                lo = lo - step;
                int hi = lo + step - 1;
                int mid = lo + (hi - lo) / 2;
                testMerge(lo, hi, mid, nums, copyResult);
            }

            step = step * 2;
            lo = 0;
        }

        if (step / 2 < nums.length) {
            lo = 0;
            int hi = nums.length - 1;
            int mid = step / 2 - 1;
            testMerge(lo, hi, mid, nums, copyResult);
        }
    }
}