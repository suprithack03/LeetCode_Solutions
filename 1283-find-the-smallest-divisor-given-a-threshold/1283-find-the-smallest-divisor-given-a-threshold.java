class Solution {
    public int smallestDivisor(int[] nums, int threshold) {

        int left = 1;
        int right = 0;

        // Find the maximum number
        for (int i = 0; i < nums.length; i++) {
            right = Math.max(right, nums[i]);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            int sum = 0;

            // Calculate the sum for this divisor
            for (int i = 0; i < nums.length; i++) {
                sum += (nums[i] + mid - 1) / mid;
            }

            if (sum <= threshold) {
                // Divisor works.
                // Try a smaller divisor.
                right = mid;
            } else {
                // Divisor is too small.
                // Need a bigger divisor.
                left = mid + 1;
            }
        }

        return left;
    }
}