class Solution {
    public int totalFruit(int[] fruits) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int max = 0;

        for (int right = 0; right < fruits.length; right++) {

            // Add fruit and increase its frequency
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // More than 2 fruit types
            while (map.size() > 2) {

                // Decrease frequency of left fruit
                map.put(fruits[left], map.get(fruits[left]) - 1);

                // If frequency becomes 0, remove the fruit type
                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                left++;
            }

            // Current window length
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}