package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author liuweilong
 * @date 2021/5/18
 * @description 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3 。
 */
public class Q104_maxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(1 + maxDepth(root.left), 1 + maxDepth(root.right));
    }

    public int maxDepthNoRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int result = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result++;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode generate = TreeNode.generate(new Integer[]{3, 9, 20, null, null, 15, 7, null, null, null, null, 1});
        int i = new Q104_maxDepth().maxDepthNoRecur(generate);
        System.out.println(i);
    }
}
