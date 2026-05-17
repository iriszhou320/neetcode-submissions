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
    int globalMax;
    public int diameterOfBinaryTree(TreeNode root) {
        globalMax = 0;
        calcHeight(root);
        return globalMax;
    }

    private int calcHeight(TreeNode node) {
        if (node == null) return 0;
        int leftHeight = calcHeight(node.left);
        int rightHeight = calcHeight(node.right);
        globalMax = Math.max(globalMax, leftHeight + rightHeight);
        int height = Math.max(leftHeight, rightHeight) + 1;
        return height;
    }
}
