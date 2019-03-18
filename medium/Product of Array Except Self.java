// two directions difference
// x 1 2 3
// 2 3 4 x
// [1, 1, 2, 6]
// [24, 12, 4, 1]
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] forward = new int[nums.length];
        int[] backward = new int[nums.length];
        int[] result = new int[nums.length];
        
        forward[0] = 1;
        for(int i = 1; i < nums.length; i++)
            forward[i] = forward[i - 1] * nums[i - 1];
        
        backward[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; i--)
            backward[i] = backward[i + 1] * nums[i + 1];
        
        for(int i = 0; i < nums.length; i++)
            result[i] = forward[i] * backward[i];
        
        return result;
    }
}

// constant space
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        
        result[0] = 1;
        for(int i = 1; i < nums.length; i++)
            result[i] = result[i - 1] * nums[i - 1];
        
        int temp = 1;
        for(int i = nums.length - 2; i >= 0; i--) {
            temp *= nums[i + 1];
            result[i] *= temp;
        }
        
        return result;
    }
}
