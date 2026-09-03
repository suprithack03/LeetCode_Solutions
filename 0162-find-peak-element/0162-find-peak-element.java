class Solution {
    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // We are going downhill.
                // A peak is on the left side or at mid.
                right = mid;
            } else {
                // We are going uphill.
                // A peak must be on the right side.
                left = mid + 1;
            }
        }

        return left;
    }
}