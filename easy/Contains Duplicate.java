public class Solution {
	public boolean containsDuplicate(int[] nums) {
		HashSet hash = new HashSet();
		
		for(int i = 0; i < nums.length; i++) {
			if(hash.contains(nums[i]))
				return true;
			else
				hash.add(nums[i]);
		}
		
		return false;
	}
}
