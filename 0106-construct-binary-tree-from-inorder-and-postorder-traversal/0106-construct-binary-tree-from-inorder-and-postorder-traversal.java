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

    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        postIndex = postorder.length - 1;

        return build(inorder, postorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] inorder, int[] postorder,
                          int left, int right) {

        if (left > right) {
            return null;
        }

        // Last element in postorder is the root
        int value = postorder[postIndex--];

        TreeNode root = new TreeNode(value);

        // Find root in inorder
        int index = left;

        while (inorder[index] != value) {
            index++;
        }

        // IMPORTANT:
        // Build right first because we are
        // moving backwards in postorder.
        root.right = build(inorder, postorder,
                           index + 1, right);

        root.left = build(inorder, postorder,
                          left, index - 1);

        return root;
    }
}