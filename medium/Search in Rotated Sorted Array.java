class Solution {
    public int search(int[] nums, int target) {
        int startIndex = 0, result = -1;
        
        int left = 0, right = nums.length - 1, pointer = (left + right) / 2;
        while(left <= right) {
            if(nums[pointer] > nums[(pointer + 1) % nums.length]) {
                startIndex = (pointer + 1) % nums.length;
                break;
            }
            else if(nums[pointer] > nums[left] || pointer == left)
                left = pointer + 1;
            else
                right = pointer - 1;
            
            pointer = (left + right) / 2;
        }
        
        left = 0;
        right = nums.length - 1;
        pointer = (left + right) / 2;
        while(left <= right) {
            if(nums[(pointer + startIndex) % nums.length] == target) {
                result = (pointer + startIndex) % nums.length;
                break;
            }
            else if(nums[(pointer + startIndex) % nums.length] > target)
                right = pointer - 1;
            else
                left = pointer + 1;
            
            pointer = (left + right) / 2;
        }
        
        return result;
    }
}
