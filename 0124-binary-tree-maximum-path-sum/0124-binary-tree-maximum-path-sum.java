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
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        findMax(root);
        return max;
    }

    public int findMax(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Find maximum path sum from left side
        int left = Math.max(0, findMax(node.left));

        // Find maximum path sum from right side
        int right = Math.max(0, findMax(node.right));

        // Path passing through current node
        int sum = node.val + left + right;

        // Update the overall maximum
        max = Math.max(max, sum);

        // Return the best one-side path to parent
        return node.val + Math.max(left, right);
    }
}