class Solution {
    public void sortColors(int[] nums) {
        int next0 = 0, next2 = nums.length - 1, current = 0;
        
        while(current <= next2) {
            if(nums[current] == 0)
                swap(nums, current, next0++);
            else if(nums[current] == 2) {
                swap(nums, current, next2--);
                if(nums[current] == 2)
                    continue;
                if(nums[current] == 0)
                    swap(nums, current, next0++);
            }
            
            current++;
        }
    }
    
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
