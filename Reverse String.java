public class Solution {
	public String reverseString(String s) {
        	char[] ch = s.toCharArray();
        	int i = 0;
        	int j = s.length() - 1;
        	char temp;
        
		while(i < j) {
			temp = ch[i];
			ch[i] = ch[j];
			ch[j] = temp;
			i++;
			j--;
		}
        
        	return new String(ch);
    	}
}
