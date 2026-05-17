/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int count;
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;
        count = 0;
        dfs(root.val, root);
        return count;
    }

    private void dfs(int max, TreeNode node) {
        int currMax = max;
        if (node == null) return;
        if (node.val >= currMax) {
            currMax = node.val;
            count++;
        }
        dfs(currMax, node.left);
        dfs(currMax, node.right);
    }
}
