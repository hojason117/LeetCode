class Solution {
    public int removeDuplicates(int[] nums) {
        int pointer = 0, len = nums.length;
        
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[pointer])
                len--;
            else
                nums[++pointer] = nums[i];
        }
        
        return len;
    }
}
