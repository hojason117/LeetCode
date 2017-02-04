public class Solution {
	public int findMaxConsecutiveOnes(int[] nums) {
		int len = 0;
		int temp = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 1)
				temp++;
			else {
				if(temp > len)
					len = temp;
				temp = 0;
			}
		}
        
		if(temp > len)
			len = temp;
        
		return len;
	}
}
