public class Solution {
	public int longestPalindrome(String s) {
        int longest = 0;
		char freq[] = new char[52];
        
        for(int i = 0; i < s.length(); i++) {
        	if(s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
        		freq[s.charAt(i)-65]++;
        	else
        		freq[s.charAt(i)-97+26]++;
        }
        
        boolean odd = false;
        for(int i = 0; i < 52; i++) {
        	if(freq[i] % 2 != 0)
        		odd = true;
        	
        	longest += freq[i] / 2 * 2;
        }
        
        if(odd)
        	longest++;
        
        return longest;
    }
}