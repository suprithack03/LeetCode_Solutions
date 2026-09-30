/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<Integer> distanceK(TreeNode root,
                                    TreeNode target,
                                    int k) {

        List<Integer> ans = new ArrayList<>();

        // Store parent of every node
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        makeParent(root, null, parent);

        // BFS starts from target
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);

        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);

        int distance = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            // We reached distance K
            if (distance == k) {

                for (int i = 0; i < size; i++) {
                    ans.add(q.poll().val);
                }

                return ans;
            }

            for (int i = 0; i < size; i++) {

                TreeNode node = q.poll();

                // Go left
                if (node.left != null &&
                    !visited.contains(node.left)) {

                    visited.add(node.left);
                    q.add(node.left);
                }

                // Go right
                if (node.right != null &&
                    !visited.contains(node.right)) {

                    visited.add(node.right);
                    q.add(node.right);
                }

                // Go to parent
                TreeNode p = parent.get(node);

                if (p != null &&
                    !visited.contains(p)) {

                    visited.add(p);
                    q.add(p);
                }
            }

            distance++;
        }

        return ans;
    }

    public void makeParent(TreeNode node,
                            TreeNode p,
                            Map<TreeNode, TreeNode> parent) {

        if (node == null) return;

        parent.put(node, p);

        makeParent(node.left, node, parent);
        makeParent(node.right, node, parent);
    }
}