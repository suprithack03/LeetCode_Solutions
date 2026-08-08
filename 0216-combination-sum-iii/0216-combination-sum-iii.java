class Solution {

    public List<List<Integer>> combinationSum3(int k, int n) {

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(1, k, n, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int start,
                           int k,
                           int target,
                           List<Integer> curr,
                           List<List<Integer>> ans) {

        if (target == 0 && curr.size() == k) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if (target < 0 || curr.size() > k) {
            return;
        }

        for (int i = start; i <= 9; i++) {

            curr.add(i);

            backtrack(i + 1,
                      k,
                      target - i,
                      curr,
                      ans);

            curr.remove(curr.size() - 1);
        }
    }
}