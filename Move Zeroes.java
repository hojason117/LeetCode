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