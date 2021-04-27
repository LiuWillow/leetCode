/**
 * @author liuweilong
 * @date 2021/4/27
 * @description 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 假设你总是可以到达数组的最后一个位置。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [2,3,0,1,4]
 * 输出: 2
 *  
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 105
 */
public class Q45_jump {
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int jump = 0;
        int currentMax = nums[0];
        if (currentMax >= nums.length - 1) {
            return 1;
        }
        for (int i = 1; i < nums.length; ) {
            jump++;
            int nextMax = currentMax;
            while (i <= currentMax) {
                nextMax = Math.max(nextMax, nums[i] + i);
                if (nextMax >= nums.length - 1) {
                    return ++jump;
                }
                i++;
            }
            currentMax = nextMax;
        }

        return jump;
    }

    /**
     * 官方写法
     * @param nums
     * @return
     */
    public int jumpOfficial(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        //length - 1 很重要
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
    public int jump_tryOfficial(int[] nums) {
        int maxPosition = 0;
        int length = nums.length;
        int step = 0;
        int end = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(nums[i] + i, maxPosition);
            if (maxPosition >= length - 1) {
                return ++step;
            }
            if (end == i) {
                end = maxPosition;
                step++;
            }
        }

        return step;
    }
    public static void main(String[] args) {
        System.out.println(new Q45_jump().jump_tryOfficial(new int[]{1}) + " 期望 0");
        System.out.println(new Q45_jump().jump_tryOfficial(new int[]{1, 2, 3}) + " 期望 2");
        System.out.println(new Q45_jump().jump_tryOfficial(new int[]{1, 2}) + " 期望 1");
        System.out.println(new Q45_jump().jump_tryOfficial(new int[]{1, 2, 1, 1}) + " 期望 2");
        System.out.println(new Q45_jump().jump_tryOfficial(new int[]{1, 2, 1, 1, 2}) + " 期望 3");
        System.out.println(new Q45_jump().jump_tryOfficial(new int[]{2, 3, 1, 1, 4}) + " 期望 2");
    }
}
