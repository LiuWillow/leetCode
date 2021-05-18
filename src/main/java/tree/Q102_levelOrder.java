package tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author liuweilong
 * @date 2021/5/18
 * @description 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
 * <p>
 *  
 * <p>
 * 示例：
 * 二叉树：[3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层序遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 */
public class Q102_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Deque<TreeNode> rootDeque = new LinkedList<>();
        rootDeque.offer(root);

        while (!rootDeque.isEmpty()) {
            int length = rootDeque.size();
            List<Integer> tmp = new ArrayList<>();
            for (int i = 0; i < length; i++) {
                TreeNode poll = rootDeque.poll();
                tmp.add(poll.val);
                if (poll.left != null) {
                    rootDeque.offer(poll.left);
                }
                if (poll.right != null) {
                    rootDeque.offer(poll.right);
                }
            }
            result.add(tmp);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
