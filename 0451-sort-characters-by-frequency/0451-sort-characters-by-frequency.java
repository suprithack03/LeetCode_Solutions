class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> map = new HashMap<>();

        // Frequency count
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Convert map to list
        List<Map.Entry<Character, Integer>> list =
                new ArrayList<>(map.entrySet());

        // Sort by frequency
        list.sort((a, b) -> b.getValue() - a.getValue());

        StringBuilder ans = new StringBuilder();

        // Normal for loop
        for (int i = 0; i < list.size(); i++) {

            char c = list.get(i).getKey();
            int freq = list.get(i).getValue();

            // Add character freq times
            for (int j = 0; j < freq; j++) {
                ans.append(c);
            }
        }

        return ans.toString();
    }
}