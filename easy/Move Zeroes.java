// counting zeros
class Solution {
	public void moveZeroes(int[] nums) {
		int zeroCount = 0;
		int p = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 0)
				zeroCount++;
			else
				nums[p++] = nums[i];
		}
		
		for(int j = 0; j < zeroCount; j++)
			nums[p++] = 0;
	}
}

// swapping
class Solution {
    public void moveZeroes(int[] nums) {
        int firstZero = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0)
                swap(nums, i, firstZero++);
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
