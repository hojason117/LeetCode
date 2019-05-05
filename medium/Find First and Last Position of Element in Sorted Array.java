class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = -1, last = -1;
        
        int left = 0, right = nums.length - 1, pointer = (left + right) / 2;
        while(left <= right) {
            if(nums[pointer] == target) {
                if(pointer == 0 || pointer > 0 && nums[pointer - 1] != target) {
                    first = pointer;
                    break;
                }
                else
                    right = pointer - 1;
            }
            else if(nums[pointer] < target)
                left = pointer + 1;
            else
                right = pointer - 1;
            
            pointer = (left + right) / 2;
        }
        
        if(first == -1)
            return new int[]{-1, -1};
        
        left = first;
        right = nums.length - 1;
        while(left <= right) {
            if(nums[pointer] == target) {
                if(pointer == nums.length - 1 || nums[pointer + 1] > target) {
                    last = pointer;
                    break;
                }
                else
                    left = pointer + 1;
            }
            else
                right = pointer - 1;
            
            pointer = (left + right) / 2;
        }
        
        return new int[]{first, last};
    }
}
