
import java.util.*;

class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {

        int n = grid.length;
        HashSet<Integer> set = new HashSet<>();

        int repeated = -1;
        int missing = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                int num = grid[i][j];

                if (!set.add(num)) {
                    repeated = num;
                }
            }
        }

        for (int i = 1; i <= n * n; i++) {

            if (!set.contains(i)) {
                missing = i;
                break;
            }
        }

        return new int[]{repeated, missing};
    }
}
