/**
 * @author liuweilong
 * @description
 * @date 2019/5/11 17:43
 */
public class Test {
    public static void main(String[] args) throws Exception {
        int[] items = new int[]{2, 3,1,4,5,6};
        new Test().knapsack2(items, 6, 10);
    }


    /**
     *
     * @param items
     * @param n 物品个数
     * @param weightCapacity
     * @return
     */
    public static int knapsack2(int[] items, int n, int weightCapacity) {
        boolean[] states = new boolean[weightCapacity+1]; // 默认值false
        states[0] = true;  // 第一行的数据要特殊处理，可以利用哨兵优化
        if (items[0] <= weightCapacity) {
            states[items[0]] = true; //第一个已经放进去了
        }
        for (int i = 1; i < n; ++i) { // 动态规划
            for (int j = weightCapacity-items[i]; j >= 0; --j) {//把第i个物品放入背包
                if (states[j]) states[j+items[i]] = true;
            }
        }
        for (int i = weightCapacity; i >= 0; --i) { // 输出结果
            if (states[i]) return i;
        }
        return 0;
    }
}
