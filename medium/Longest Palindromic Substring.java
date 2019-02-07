class Solution {
    public String longestPalindrome(String s) {
        String longestResult = "";
        
        for(int i = 0; i < s.length(); i++) {
            String temp = helper(i - 1, i + 1, s, longestResult.length());
            if(temp != null)
                longestResult = temp;
            
            temp = helper(i, i + 1, s, longestResult.length());
            if(temp != null)
                longestResult = temp;
        }
        
        return longestResult;
    }
    
    private String helper(int left, int right, String s, int currentMax) {
        while(left >= 0 && right < s.length()) {
            if(s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            else
                break;
        }
        
        return (right - left - 1 > currentMax) ? s.substring(left + 1, right) : null;
    }
}

// Brute Force
class Solution {
    public String longestPalindrome(String s) {
        String longestResult = "";
        for(int j = 0; j < s.length(); j++) {
            if(s.length() - j < longestResult.length())
                return longestResult;
            for(int i = s.length(); i > j; i--) {
                String temp = s.substring(j, i);
                if(isPalindrome(temp) && temp.length() > longestResult.length())
                    longestResult = temp;
            }
        }
        
        return longestResult;
    }
    
    private boolean isPalindrome(String s) {
        for(int i = 0; i < s.length() / 2; i++) {
            if(s.charAt(i) != s.charAt(s.length() - i - 1))
                return false;
        }
        
        return true;
    }
}
