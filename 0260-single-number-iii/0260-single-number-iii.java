class Solution {
    public int[] singleNumber(int[] nums) {
        int xor = 0;

        // XOR all numbers
        for (int i = 0; i < nums.length; i++) {
            xor ^= nums[i];
        }

        // Get the rightmost set bit
        int bit = xor & (-xor);

        int a = 0;
        int b = 0;

        // Divide numbers into two groups
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & bit) == 0) {
                a ^= nums[i];
            } else {
                b ^= nums[i];
            }
        }

        return new int[]{a, b};
    }
}