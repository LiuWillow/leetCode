package tree;

import java.util.Stack;

/**
 * @author liuweilong
 * @date 2021/5/13
 * @description 给定一个二叉树，检查它是否是镜像对称的。
 * <p>
 *  
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 * 1
 * / \
 * 2   2
 * / \ / \
 * 3  4 4  3
 *  
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 * 1
 * / \
 * 2   2
 * \   \
 * 3    3
 */
public class Q101_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetric(root.left, root.right);
    }

    //左子树左移，右子树右移
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null ^ right == null) {
            return false;
        }
        if (left == null) {
            return true;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public boolean isSymmetric_noRecur(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode leftRoot = root.left;
        TreeNode rightRoot = root.right;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(leftRoot);
        stack.push(rightRoot);
        while (!stack.isEmpty()) {
            TreeNode right = stack.pop();
            TreeNode left = stack.pop();
            if (right == null && left == null) {
                continue;
            }
            if (right == null || left == null) {
                return false;
            }

            if (right.val != left.val) {
                return false;
            }

            stack.push(right.right);
            stack.push(left.left);
            stack.push(left.right);
            stack.push(right.left);
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);

        System.out.println(new Q101_isSymmetric().isSymmetric_noRecur(root));
    }
}
