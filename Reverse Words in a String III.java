public class Solution {
	public String reverseWords(String s) {
        char temp[] = new char[100];
		int length = 0;
        StringBuilder result = new StringBuilder();
		
		for(int pos = 0; pos < s.length(); pos++) {
			if(s.charAt(pos) == ' ') {
				for(int i = length - 1; i >= 0; i--)
					result.append(temp[i]);
				result.append(' ');
				length = 0;
			}
			else
				temp[length++] = s.charAt(pos);
		}
		
		for(int i = length - 1; i >= 0; i--)
			result.append(temp[i]);
		
		return result.toString();
    }
}