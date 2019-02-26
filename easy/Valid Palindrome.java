class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        
        int i = 0, j = s.length() - 1;
        while(i <= j) {
            char left = s.charAt(i);
            char right = s.charAt(j);
            if(!((left >= '0' && left <= '9') || (left >= 'a' && left <= 'z')))
                i++;
            else if(!((right >= '0' && right <= '9') || (right >= 'a' && right <= 'z')))
                j--;
            else {
                if(left != right)
                    return false;
                
                i++;
                j--;
            }
        }
        
        return true;
    }
}
