class Solution {
    public int numSquares(int n) {
        int[] memo = new int[n];
        return helper(n, memo);
    }
    
    private int helper(int target, int[] memo) {
        if(target == 0)
            return 0;
        
        if(memo[target - 1] != 0)
            return memo[target - 1];
        
        int start = (int)Math.sqrt(target);
        int min = Integer.MAX_VALUE;
        
        for(int i = start; i > 0; i--) {
            int temp = helper(target - i * i, memo);
            if(temp < min)
                min = temp;
        }
        
        memo[target - 1] = min + 1;
        
        return min + 1;
    }
}
