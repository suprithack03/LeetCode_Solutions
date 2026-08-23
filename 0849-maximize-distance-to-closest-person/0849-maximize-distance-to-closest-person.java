class Solution {
    public int maxDistToClosest(int[] seats) {

        int prev = -1;
        int max = 0;

        for (int i = 0; i < seats.length; i++) {

            if (seats[i] == 1) {

                if (prev == -1) {
                    // Empty seats before first person
                    max = i;
                } 
                else {
                    // Empty seats between two people
                    max = Math.max(max, (i - prev) / 2);
                }

                prev = i;
            }
        }

        // Empty seats after last person
        max = Math.max(max, seats.length - 1 - prev);

        return max;
    }
}