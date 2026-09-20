class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int left = 0;
        int right = 0;

        // Find minimum and maximum possible capacity
        for (int i = 0; i < weights.length; i++) {
            left = Math.max(left, weights[i]);
            right += weights[i];
        }

        while (left < right) {

            int mid = (left + right) / 2;

            int currentWeight = 0;
            int countDays = 1;

            // Check how many days are needed
            // if ship capacity is 'mid'
            for (int i = 0; i < weights.length; i++) {

                if (currentWeight + weights[i] > mid) {
                    countDays++;
                    currentWeight = 0;
                }

                currentWeight += weights[i];
            }

            if (countDays <= days) {
                // Capacity is enough.
                // Try a smaller capacity.
                right = mid;
            } else {
                // Capacity is not enough.
                // Need a bigger capacity.
                left = mid + 1;
            }
        }

        return left;
    }
}