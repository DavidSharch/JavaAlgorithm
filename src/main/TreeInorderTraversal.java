package main;

import pkg.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author : sharch
 * @create 2023/10/2 20:43
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 */
public class TreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inorder(root, result);
        return result;
    }

    public void inorder(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        inorder(root.left, result);  // 左
        result.add(root.val);    // 中
        inorder(root.right, result); // 右
    }
}
