public class Solution {
	public int hammingDistance(int x, int y) {
        	int temp = x ^ y;
        
        	int result = 0;
		for(int i = 30; i >= 0; i--) {
			if(temp / (int)Math.pow(2, i) == 1)  {
				temp %= (int)Math.pow(2, i);
				result++;
        		}
        	}
        
        	return result;
	}
}
