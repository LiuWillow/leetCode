package tree;


import java.util.Stack;

/**
 * @author liuweilong
 * @date 2021/5/13
 * @description 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 假设一个二叉搜索树具有如下特征：
 * <p>
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class Q98_isValidBST {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode root, long left, long right) {
        if (root == null) {
            return true;
        }
        if (root.val <= left || root.val >= right) {
            return false;
        }
        return isValidBST(root.left, left, root.val)
                && isValidBST(root.right, Math.max(left, root.val), right);
    }

    // 中序遍历，返回的结果一定是升序的
    public boolean isValidBST_zhongxu(TreeNode root) {
        long pre = Long.MIN_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val <= pre) {
                return false;
            }
            pre = root.val;
            root = root.right;
        }
        return true;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.left = new TreeNode(3);
        System.out.println(new Q98_isValidBST().isValidBST(root));
    }
}
