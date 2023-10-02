package main;


import pkg.TreeNode;

/**
 * @Author : sharch
 * @create 2023/10/2 20:08
 * https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 */
public class MaxTreeDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return depth(root);
    }

    private int depth(TreeNode root) {
        int left = 0, right = 0;
        if (root.left == null && root.right == null) {
            return 1;
        }
        if (root.left != null) {
            left += depth(root.left);
        }
        if (root.right != null) {
            right += depth(root.right);
        }
        return 1 + Math.max(left, right);
    }


    public int maxDepthV2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return recursionHelper(root);
    }
    public int recursionHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = recursionHelper(root.left) + 1;
        int rightDepth = recursionHelper(root.right) + 1;
        return Math.max(leftDepth, rightDepth);
    }
}
