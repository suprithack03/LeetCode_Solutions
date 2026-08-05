class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(int[] candidates,
                           int target,
                           int index,
                           List<Integer> curr,
                           List<List<Integer>> ans) {

        // Base Case
        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        // Invalid Case
        if (target < 0 || index == candidates.length) {
            return;
        }

        // Choice 1: Take current element
        curr.add(candidates[index]);
        backtrack(candidates, target - candidates[index], index, curr, ans);
        curr.remove(curr.size() - 1);   // Backtrack

        // Choice 2: Skip current element
        backtrack(candidates, target, index + 1, curr, ans);
    }
}