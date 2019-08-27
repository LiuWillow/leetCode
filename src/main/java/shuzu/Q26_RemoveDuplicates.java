package shuzu;

import java.util.Arrays;

/**
 * author liuweilong
 * date 2019/8/23 18:04
 * desc
 * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 示例 1:
 * <p>
 * 给定数组 nums = [1,1,2],
 * <p>
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 * 示例 2:
 * <p>
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 * <p>
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 * <p>
 * 你不需要考虑数组中超出新长度后面的元素。
 */
public class Q26_RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        //一个指针指向正在移动的index，每次去重都要减少对应个数
        //另一个指针指向第一个非重复元素
        int distinctIndex = 0;
        //计算边界
        int movingIndex = 0;
        while (movingIndex < nums.length) {
            int first = nums[movingIndex];
            while (movingIndex + 1 < nums.length && nums[movingIndex + 1] == first) {
                movingIndex++;
            }
            //到这一步，movingIndex还没移动到下一个不一样的元素位置
            movingIndex++;
            if (movingIndex >= nums.length){
                break;
            }
            nums[++distinctIndex] = nums[movingIndex];
        }
        return distinctIndex + 1;
    }

    public static void main(String[] args) {
       int[] array = new int[]{0,0,1,1,1,2,2,3,3,4};
        System.out.println(new Q26_RemoveDuplicates().removeDuplicates(array));
        System.out.println(Arrays.toString(array));
    }
}
