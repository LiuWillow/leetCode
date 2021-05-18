package tree;

import util.Lists;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liuweilong
 * @date 2021/5/18
 * @description 给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回锯齿形层序遍历如下：
 * <p>
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 */
public class Q103_zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int order = 1; //1表示从左到右，-1表示从右到左
        while (!queue.isEmpty()) {
            int length = queue.size();
            Deque<Integer> tmp = new LinkedList<>();
            for (int i = 0; i < length; i++) {
                TreeNode node = queue.poll();
                if (order == 1) {
                    tmp.offerLast(node.val);
                } else {
                    tmp.offerFirst(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(new ArrayList<>(tmp));

            order = -order;
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode node = TreeNode.generate(new Integer[]{0, 2, 4, 1, null, 3, -1, 5, 1, null, 6, null, 8});
        List<List<Integer>> lists = new Q103_zigzagLevelOrder().zigzagLevelOrder(node);
        Lists.print(lists);
    }
}
