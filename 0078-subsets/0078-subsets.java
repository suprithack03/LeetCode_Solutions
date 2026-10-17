import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();

        backtrack(0, nums, current, ans);

        return ans;
    }

    public void backtrack(int index, int[] nums,
                          List<Integer> current,
                          List<List<Integer>> ans) {

        if (index == nums.length) {
            ans.add(new ArrayList<>(current));
            return;
        }

        // Include the current element
        current.add(nums[index]);
        backtrack(index + 1, nums, current, ans);

        // Remove the current element (backtrack)
        current.remove(current.size() - 1);

        // Exclude the current element
        backtrack(index + 1, nums, current, ans);
    }
}