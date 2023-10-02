package pkg;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Author : sharch
 * @create 2023/10/2 20:15
 */
public class TreeBFS {
    public List<TreeNode> BFS(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        res.add(root);
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.add(node.left);
                    res.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                    res.add(node.right);
                }
                size--;
            }
        }
        return res;
    }
}
