class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));

        int remove = 0;
        int previousEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] < previousEnd) {
                // Overlap
                remove++;

                // Keep the interval ending earlier
                previousEnd = Math.min(previousEnd, intervals[i][1]);
            } else {
                // No overlap
                previousEnd = intervals[i][1];
            }
        }

        return remove;
    }
}