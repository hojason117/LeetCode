// dynamic programming
class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        
        int[] memo = new int[prices.length];
        
        memo[memo.length - 1] = prices[prices.length - 1];
        for(int i = prices.length - 2; i >= 0; i--)
            memo[i] = Math.max(prices[i], memo[i + 1]);
        
        int max = 0;
        for(int i = 0; i < prices.length; i++) {
            if(memo[i] - prices[i] > max)
                max = memo[i] - prices[i];
        }
        
        return max;
    }
}

// one pass
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0, minValue = Integer.MAX_VALUE;
        
        for(int i : prices) {
            if(i < minValue)
                minValue = i;
            else {
                if(i - minValue > maxProfit)
                    maxProfit = i - minValue;
            }
        }
        
        return maxProfit;
    }
}
