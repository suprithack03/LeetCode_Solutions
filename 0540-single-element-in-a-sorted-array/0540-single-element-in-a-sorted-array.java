class Solution {
    public int singleNonDuplicate(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int mid = (left + right) / 2;

            // Make mid even
            if (mid % 2 == 1) {
                mid--;
            }

            if (nums[mid] == nums[mid + 1]) {
                // Pair is correct: (mid, mid+1)
                // Single element is on the right
                left = mid + 2;
            } else {
                // Pair is broken
                // Single element is at mid or on the left
                right = mid;
            }
        }

        return nums[left];
    }
}