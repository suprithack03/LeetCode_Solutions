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

    public int countNodes(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int h = getHeight(root);

        // Perfect tree
        if (h == 0) {
            return 1;
        }

        int left = 0;
        int right = (1 << h) - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (exists(root, h, mid)) {
                // Node exists
                left = mid + 1;
            } else {
                // Node does not exist
                right = mid - 1;
            }
        }

        // Nodes before last level + nodes in last level
        return (1 << h) - 1 + left;
    }

    // Height excluding the last level
    public int getHeight(TreeNode root) {

        int h = 0;

        while (root.left != null) {
            h++;
            root = root.left;
        }

        return h;
    }

    // Check whether a node exists at index idx
    public boolean exists(TreeNode root, int h, int idx) {

        int left = 0;
        int right = (1 << h) - 1;

        for (int i = 0; i < h; i++) {

            int mid = (left + right) / 2;

            if (idx <= mid) {
                root = root.left;
                right = mid;
            } else {
                root = root.right;
                left = mid + 1;
            }
        }

        return root != null;
    }
}