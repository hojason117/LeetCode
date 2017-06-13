public class Solution {
	public int[][] matrixReshape(int[][] nums, int r, int c) {
		if(nums.length * nums[0].length != r * c)
			return nums;
		
		int result[][] = new int[r][c];
		int r_temp = 0, c_temp = 0;
		
		for(int i = 0; i < nums.length; i++) {
			for(int j = 0; j < nums[i].length; j++) {
				result[r_temp][c_temp++] = nums[i][j];				
				if(c_temp == c) {
					r_temp++;
					c_temp = 0;
				}
			}
		}
		
		return result;
    }
}