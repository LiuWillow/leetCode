package baseSuanfa;

import java.util.Arrays;

public class DuiSort {
    /**
     * 先构造堆
     * 然后将堆顶元素与最后一个元素交换，下沉当前对顶元素，忽略最后一个
     * @param nums
     */
    public void sort(int[] nums){
        build(nums);
        int N = nums.length - 1;
        while (N > 0){
            int topNum = nums[1];
            nums[1] = nums[N];
            nums[N] = topNum;
            sink(nums, 1, --N);
        }
    }

    /**
     * 构造要从最后一个父节点开始下沉
     * 数组第一位默认不存值，计算方便
     * @param nums
     */
    public void build(int[] nums){
        int N = nums.length - 1;
        //最后一个父节点为 N / 2
        for (int i = N / 2; i > 0; i--) {
            sink(nums, i, N);
        }
    }

    /**
     * 比较初始节点与两个子节点的大小，与较大的交换，然后*2遍历下层节点
     * @param nums
     * @param begin
     * @param end
     */
    public void sink(int[] nums, int begin, int end){
        while (2 * begin <= end){
            int numBegin = nums[begin];
            int left = begin * 2;
            int numLeft = nums[left];
            int right = left + 1;
            int numRight = 0;
            if (right <= end){
                numRight = nums[right];
            }
            int p = left;
            int max = numLeft;
            if (numLeft < numRight){
                p = right;
                max = numRight;
            }

            if (max <= numBegin){
                break;
            }

            nums[begin] = max;
            nums[p] = numBegin;

            begin = p;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 34, 4, 6, 7, 3, 2, 3, 55, 2, 34, 53};
        new DuiSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
