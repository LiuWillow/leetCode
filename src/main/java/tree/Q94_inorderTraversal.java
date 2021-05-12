package tree;

import util.Lists;

import java.util.*;

/**
 * @author liuweilong
 * @date 2021/5/12
 * @description 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class Q94_inorderTraversal {
    /**
     * 递归
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }

    /**
     * 非递归版本
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal_noRecur(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();
        while (root != null || !queue.isEmpty()) {
            while (root != null) {
                queue.push(root);
                root = root.left;
            }
            root = queue.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }

    public List<Integer> inorderTraversal_noRecur_tryMySelf(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            root = stack.pop();
            result.add(root.val);
            root = root.right;
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);

        Lists.print(new Q94_inorderTraversal().inorderTraversal_noRecur_tryMySelf(root));
    }
}
