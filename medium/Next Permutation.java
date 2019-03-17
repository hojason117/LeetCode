class Solution {
    public void nextPermutation(int[] nums) {
        int startMonotonicDecrease = 0;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i - 1])
                startMonotonicDecrease = i;
        }
        
        if(startMonotonicDecrease == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        
        int nextSmallest = startMonotonicDecrease;
        for(int i = startMonotonicDecrease; i < nums.length; i++) {
            if(nums[i] > nums[startMonotonicDecrease - 1] && nums[i] <= nums[nextSmallest])
                nextSmallest = i;
        }
        
        swap(nums, nextSmallest, startMonotonicDecrease - 1);
        
        reverse(nums, startMonotonicDecrease, nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        for(int i = 0; i <= (end - start) / 2; i++)
            swap(nums, start + i, end - i);
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
