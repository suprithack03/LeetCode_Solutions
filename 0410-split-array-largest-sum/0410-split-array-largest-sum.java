class Solution {
    public int splitArray(int[] nums, int k) {

        int left = 0;
        int right = 0;

        // Minimum possible answer = largest element
        // Maximum possible answer = total sum
        for (int i = 0; i < nums.length; i++) {
            left = Math.max(left, nums[i]);
            right += nums[i];
        }

        while (left < right) {

            int mid = (left + right) / 2;

            int sum = 0;
            int count = 1;

            // Check how many subarrays are needed
            // if the maximum allowed sum is mid
            for (int i = 0; i < nums.length; i++) {

                if (sum + nums[i] > mid) {
                    count++;
                    sum = 0;
                }

                sum += nums[i];
            }

            if (count <= k) {
                // mid works
                // Try a smaller maximum sum
                right = mid;
            } else {
                // mid is too small
                // Need a larger maximum sum
                left = mid + 1;
            }
        }

        return left;
    }
}