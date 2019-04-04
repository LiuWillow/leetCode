package baseSuanfa;

import java.util.Arrays;

/**
 * @author lwl
 * @date 2019/4/3 17:06
 * @description 插入排序
 * 当前索引左边的元素都是有序的，即从0个元素开始，一个个插入元素，每次插入一个元素都放在之前元素的末尾，一个个往前移
 */
public class InsertSort {
    public void sort(int[] nums){
        //遍历数组，每次取出一个作为元素插入
        //记录插入元素的index，与前一个比较，如果比前一个小，则交换
        int length = nums.length;
        for (int i = 1; i < length; i++) {
            for (int j = i - 1; j >= 0 ; j--) {
                while (nums[j + 1] < nums[j] && j >= 0){
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{34,4,6,7,3,2,3,55,2,34,53};
        new InsertSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}