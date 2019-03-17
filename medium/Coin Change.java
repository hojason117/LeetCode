// hashmap
class Solution {
    Map<Integer, Integer> memo = new HashMap<Integer, Integer>();
    
    public int coinChange(int[] coins, int amount) {
        if(amount < 0)
            return -1;
        if(amount == 0)
            return 0;
        
        if(memo.containsKey(amount))
            return memo.get(amount);
        
        int min = Integer.MAX_VALUE;
        for(int c : coins) {
            int temp = coinChange(coins, amount - c);
            if(temp != -1 && temp < min)
                min = temp;
        }
        
        memo.put(amount, (min == Integer.MAX_VALUE) ? -1 : min + 1);
        
        return memo.get(amount);
    }
}

// int array
class Solution {    
    public int coinChange(int[] coins, int amount) {
        return helper(coins, amount, new int[amount]);
    }
    
    private int helper(int[] coins, int amount, int[] memo) {
        if(amount < 0)
            return -1;
        if(amount == 0)
            return 0;
        
        if(memo[amount - 1] != 0)
            return memo[amount - 1];
        
        int min = Integer.MAX_VALUE;
        for(int c : coins) {
            int temp = helper(coins, amount - c, memo);
            if(temp != -1 && temp < min)
                min = temp;
        }
        
        memo[amount - 1] = (min == Integer.MAX_VALUE) ? -1 : min + 1;
        
        return memo[amount - 1];
    }
}
