package tree;

/**
 * @author liuweilong
 * @date 2021/5/13
 * @description
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 *
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 */
public class Q100_isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q ==null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}