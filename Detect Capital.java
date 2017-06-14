public class Solution {
	public boolean detectCapitalUse(String word) {
		if(word.length() == 1)
			return true;
		
        if(word.charAt(0) >= 65 && word.charAt(0) <= 90) {
        	if(word.charAt(1) >= 65 && word.charAt(1) <= 90) {
        		for(int i = 2; i < word.length(); i++) {
            		if(!(word.charAt(i) >= 65 && word.charAt(i) <= 90))
            			return false;
            	}
        	}
        	else
        		for(int i = 2; i < word.length(); i++) {
            		if(!(word.charAt(i) >= 97 && word.charAt(i) <= 122))
            			return false;
            	}
        }
        else {
        	for(int i = 1; i < word.length(); i++) {
        		if(!(word.charAt(i) >= 97 && word.charAt(i) <= 122))
        			return false;
        	}
        }
		
		return true;
    }
}