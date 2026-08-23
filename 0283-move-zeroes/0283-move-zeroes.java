class Solution {
    public void moveZeroes(int[] nums) {
        int j = -1;

        // find the FIRST zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // if no zero is present, nothing to do
        if (j == -1) return;

        // move non-zero elements after first zero
        for (int i = j + 1; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++;
            }
        }
    }
}
