/**
 * @author lwl
 * @date 2019/3/27 17:54
 * @description 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，
 * 垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i <= j) {
            int leftHeight = height[i];
            int rightHeight = height[j];
            int area;
            if (leftHeight > rightHeight) {
                area = rightHeight * (j-- - i);
            } else {
                area = leftHeight * (j - i++);
            }
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] x = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new MaxArea().maxArea(x));
    }
}