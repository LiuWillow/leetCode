package baseSuanfa;

import java.util.Arrays;

/**
 * @author lwl
 * @date 2019/4/3 17:06
 * @description 插入排序
 * 当前索引左边的元素都是有序的，即从0个元素开始，一个个插入元素，每次插入一个元素都放在之前元素的末尾，一个个往前移
 */
public class InsertSort {
    // 插入排序，a 表示数组，n 表示数组大小
    public void sort(int[] a) {
        int n = a.length;
        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j+1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j+1] = value; // 插入数据
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{34,4,6,7,3,2,3,55,2,34,53};
        new InsertSort().sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}