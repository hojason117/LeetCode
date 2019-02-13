class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> valToIndex = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++)
            valToIndex.put(nums[i], i);
        
        for(int i = 0; i < nums.length; i++) {
            Integer index = valToIndex.get(target - nums[i]);
            if(index != null && index != i)
                return new int[]{i, index};
        }
        
        return new int[]{0, 0};
    }
}
