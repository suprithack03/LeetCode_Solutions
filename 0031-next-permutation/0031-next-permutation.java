class Solution {
    public void nextPermutation(int[] nums) {

        int i = nums.length - 2;

        // 1. Find the first decreasing element from right
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // 2. Find element just greater than nums[i]
        if (i >= 0) {

            int j = nums.length - 1;

            while (nums[j] <= nums[i]) {
                j--;
            }

            // Swap
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // 3. Reverse the remaining part
        int left = i + 1;
        int right = nums.length - 1;

        while (left < right) {

            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }
}