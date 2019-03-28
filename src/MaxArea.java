/**
 * @author lwl
 * @date 2019/3/27 17:54
 * @description
 */
public class MaxArea {
    public int maxArea(int[] height) {
        int i = 0;
        int j = height.length - 1;
        int maxArea = 0;
        while (i <= j) {
            int leftHeight = height[i];
            int rightHeight = height[j];
            int tempHeight = leftHeight;
            int area;
            if (leftHeight > rightHeight) {
                tempHeight = rightHeight;
                area = tempHeight * (j-- - i);
            } else {
                area = tempHeight * (j - i++);
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