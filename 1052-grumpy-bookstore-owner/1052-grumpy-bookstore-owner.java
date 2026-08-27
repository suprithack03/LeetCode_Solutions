class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {

        int happy = 0;

        // Customers who are already happy
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                happy += customers[i];
            }
        }

        int extra = 0;
        int maxExtra = 0;

        // Sliding window
        for (int i = 0; i < customers.length; i++) {

            if (grumpy[i] == 1) {
                extra += customers[i];
            }

            // Remove the element that leaves the window
            if (i >= minutes && grumpy[i - minutes] == 1) {
                extra -= customers[i - minutes];
            }

            maxExtra = Math.max(maxExtra, extra);
        }

        return happy + maxExtra;
    }
}