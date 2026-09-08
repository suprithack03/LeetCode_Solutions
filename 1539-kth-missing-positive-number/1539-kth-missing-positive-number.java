class Solution {
    public int findKthPositive(int[] arr, int k) {

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int mid = (left + right) / 2;

            int missing = arr[mid] - (mid + 1);

            if (missing < k) {
                // Not enough missing numbers
                // Go right
                left = mid + 1;
            } else {
                // Enough missing numbers
                // Go left
                right = mid - 1;
            }
        }

        return left + k;
    }
}