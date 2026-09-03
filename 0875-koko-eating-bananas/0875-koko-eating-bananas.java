class Solution {
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 0;

        // Find maximum pile
        for (int i = 0; i < piles.length; i++) {
            right = Math.max(right, piles[i]);
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            int hours = 0;

            // Calculate total hours
            for (int i = 0; i < piles.length; i++) {
                hours += (piles[i] + mid - 1) / mid;
            }

            if (hours <= h) {
                right = mid;       // Try smaller speed
            } else {
                left = mid + 1;    // Need bigger speed
            }
        }

        return left;
    }
}