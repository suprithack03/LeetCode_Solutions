class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // 1. Count frequency
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // 2. Create buckets
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        // Convert HashMap keys to array
        Integer[] keys = map.keySet().toArray(new Integer[0]);

        // 3. Put numbers into frequency buckets
        for (int i = 0; i < keys.length; i++) {

            int num = keys[i];
            int freq = map.get(num);

            if (bucket[freq] == null) {
                bucket[freq] = new ArrayList<>();
            }

            bucket[freq].add(num);
        }

        // 4. Take k most frequent elements
        int[] ans = new int[k];
        int index = 0;

        for (int i = bucket.length - 1; i >= 0 && index < k; i--) {

            if (bucket[i] != null) {

                for (int j = 0; j < bucket[i].size() && index < k; j++) {
                    ans[index] = bucket[i].get(j);
                    index++;
                }
            }
        }

        return ans;
    }
}