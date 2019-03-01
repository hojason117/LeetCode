class Solution {
    public boolean validPalindrome(String s) {
        return validate(s, 0, s.length() - 1, false);
    }
    
    private boolean validate(String s, int left, int right, boolean skipped) {
        if(left >= right)
            return true;
        
        if(s.charAt(left) != s.charAt(right)) {
            if(skipped)
                return false;
            else
                return validate(s, left + 1, right, true) || validate(s, left, right - 1, true);
        }
        else
            return validate(s, left + 1, right - 1, skipped);
    }
}
