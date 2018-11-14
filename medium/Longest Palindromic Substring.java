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