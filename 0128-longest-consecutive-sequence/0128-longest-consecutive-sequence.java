class Solution {
    public int longestConsecutive(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        // Put all numbers in Set
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        Integer[] arr = set.toArray(new Integer[0]);

        int longest = 0;

        // Loop through unique numbers only
        for (int i = 0; i < arr.length; i++) {

            int num = arr[i];

            // Start of a sequence
            if (!set.contains(num - 1)) {

                int count = 1;

                while (set.contains(num + 1)) {
                    num++;
                    count++;
                }

                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}