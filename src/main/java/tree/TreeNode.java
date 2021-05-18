package tree;

/**
 * @author liuweilong
 * @date 2021/5/12
 * @description
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static TreeNode generate(Integer[] nums) {
        return generate(nums, 0);
    }

    private static TreeNode generate(Integer[] nums, int k) {
        if (k >= nums.length) {
            return null;
        }
        if (nums[k] == null) {
            return null;
        }
        TreeNode node = new TreeNode();
        node.val = nums[k];
        node.left = generate(nums, 2 * k + 1);
        node.right = generate(nums, 2 * k + 2);
        return node;
    }
}
