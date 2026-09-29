class Solution {
    public int minimumSize(int[] nums, int maxOperations) {

        int left = 1;
        int right = 0;

        // Maximum possible answer
        for (int i = 0; i < nums.length; i++) {
            right = Math.max(right, nums[i]);
        }

        while (left < right) {

            int mid = (left + right) / 2;

            int operations = 0;

            // Check how many splits are needed
            // if maximum bag size is mid
            for (int i = 0; i < nums.length; i++) {

                operations += (nums[i] - 1) / mid;
            }

            if (operations <= maxOperations) {
                // mid is possible
                // Try a smaller maximum size
                right = mid;
            } else {
                // Need too many operations
                // Increase the allowed size
                left = mid + 1;
            }
        }

        return left;
    }
}