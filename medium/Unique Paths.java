class Solution {
    HashMap<List<Integer>, Integer> memo = new HashMap<List<Integer>, Integer>();
    
    public int uniquePaths(int m, int n) {
        if(m == 1 || n == 1)
            return 1;
        
        List<Integer> step = Arrays.asList(new Integer[]{m, n});
        if(memo.containsKey(step))
            return memo.get(step);
        else {
            int right = uniquePaths(m - 1, n);
            int down = uniquePaths(m, n - 1);
            
            memo.put(step, right + down);
            return right + down;            
        }
    }
}