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
    public boolean isSameTree(TreeNode p, TreeNode q) {

        // Both are null → same
        if (p == null && q == null) {
            return true;
        }

        // One is null → not same
        if (p == null || q == null) {
            return false;
        }

        // Values are different → not same
        if (p.val != q.val) {
            return false;
        }

        // Check left side AND right side
        return isSameTree(p.left, q.left) &&
               isSameTree(p.right, q.right);
    }
}