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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }

    public void postorder(TreeNode node, List<Integer> ans) {
        if (node == null) {
            return;
        }

        postorder(node.left, ans);   // Left
        postorder(node.right, ans);  // Right
        ans.add(node.val);           // Root
    }
}