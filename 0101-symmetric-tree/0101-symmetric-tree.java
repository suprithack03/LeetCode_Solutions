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
    public boolean isSymmetric(TreeNode root) {
        return check(root.left, root.right);
    }

    public boolean check(TreeNode left, TreeNode right) {

        // Both are null → symmetric
        if (left == null && right == null) {
            return true;
        }

        // One is null → not symmetric
        if (left == null || right == null) {
            return false;
        }

        // Values are different → not symmetric
        if (left.val != right.val) {
            return false;
        }

        // Compare opposite sides
        return check(left.left, right.right) &&
               check(left.right, right.left);
    }
}