public class Solution {
	public int findComplement(int num) {
		int zeroCount = Integer.numberOfLeadingZeros(num);
		String s = "";
		
        	for(int i = 0; i < 32-zeroCount; i++)
        		s += '1';
        
        	return num ^ Integer.parseInt(s, 2);
    	}
}
