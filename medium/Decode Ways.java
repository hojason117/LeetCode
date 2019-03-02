// recursive
class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0)
            return 0;
        int[] memo = new int[s.length()];
        return helper(s, memo, 0);
    }
    
    private int helper(String s, int[] memo, int start) {
        if(start == s.length())
            return 1;
        if(s.charAt(start) == '0')
            return 0;
        if(memo[start] != 0)
            return memo[start];
        
        int count = 0;
        if(start < s.length())
            count += helper(s, memo, start + 1);
        if(start < s.length() - 1 && Integer.valueOf(s.substring(start, start + 2)) <= 26)
            count += helper(s, memo, start + 2);
        
        memo[start] = count;
        
        return count;
    }
}

// iterative
class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length() + 1];
        memo[s.length()] = 1;
        memo[s.length() - 1] = (s.charAt(s.length() - 1) == '0') ? 0: 1;
        
        for(int i = s.length() - 2; i >= 0; i--) {
            if(s.charAt(i) == '0')
                continue;
            
            memo[i] = memo[i + 1];
            if(Integer.valueOf(s.substring(i, i + 2)) <= 26)
                memo[i] += memo[i + 2];
        }
        
        return memo[0];
    }
}
