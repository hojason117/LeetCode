class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0)
            return 0;
        
        int min = -1, left = 0, right = 0, sum = nums[0];
        
        while(true) {
            if(sum >= s) {
                if(right - left + 1 < min || min == -1)
                    min = right - left + 1;
                sum -= nums[left];
                left++;
            }
            else {
                if(right + 1 == nums.length)
                    break;
                
                right++;
                sum += nums[right];
            }
        }
        
        return (min == -1) ? 0 : min;
    }
}
