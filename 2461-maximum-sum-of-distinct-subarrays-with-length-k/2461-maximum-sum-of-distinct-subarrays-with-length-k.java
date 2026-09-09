import java.util.HashMap;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {

        long sum = 0;
        long max = 0;
        int left = 0;

        HashMap<Integer, Integer> hash = new HashMap<>();

        for(int right = 0; right < nums.length; right++){

            sum = sum + nums[right];
            hash.put(nums[right], hash.getOrDefault(nums[right], 0) + 1);

            while(right - left + 1 > k){
                sum = sum - nums[left];

                hash.put(nums[left], hash.get(nums[left]) - 1);
                if(hash.get(nums[left]) == 0){
                    hash.remove(nums[left]);         //remove left ones from map
                }

                left++;
            }

            if(hash.size() == k){
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}
