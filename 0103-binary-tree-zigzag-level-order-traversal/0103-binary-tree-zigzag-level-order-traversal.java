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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);

        boolean leftToRight = true;

        while (!q.isEmpty()) {

            int size = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode node;

                if (leftToRight) {
                    node = q.removeFirst();

                    level.add(node.val);

                    // Add children in left → right order
                    if (node.left != null) {
                        q.addLast(node.left);
                    }

                    if (node.right != null) {
                        q.addLast(node.right);
                    }

                } else {
                    node = q.removeLast();

                    level.add(node.val);

                    // Add children in right → left order
                    if (node.right != null) {
                        q.addFirst(node.right);                                    
                    }

                    if (node.left != null) {
                        q.addFirst(node.left);
                    }
                }
            }

            ans.add(level);

            leftToRight = !leftToRight;
        }

        return ans;
    }
}

// We use a Deque (double-ended queue) because we can add and remove nodes from both ends.
// We first add the root node, then process the tree level by level.
// For each level, we take nodes from one end of the Deque and add their children for the next level.
// The direction is reversed after every level, so one level is processed from left to right,
// and the next level is processed from right to left, creating the zigzag order.