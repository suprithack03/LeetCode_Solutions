import java.util.Arrays;

class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);

        int number = 1;
        int i = 0;
                                                         //find if 1 is there or not , next check for 2 likewise 
        while (i < nums.length) {

            if (nums[i] == number) {
                number++;
            }

            i++;
        }

        return number;
    }
}
            

            
        
