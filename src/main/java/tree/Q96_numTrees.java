package tree;

/**
 * @author liuweilong
 * @date 2021/5/12
 * @description
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */
public class Q96_numTrees {
    public int numTrees(int n) {
        int[] g = new int[n + 1];
        g[0] = 1;//重要，空树也算一种情况
        g[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                g[i] += g[j - 1] * g[i - j];
            }
        }
        return g[n];
    }

    public static void main(String[] args) {
        System.out.println(new Q96_numTrees().numTrees(3));
    }
}
