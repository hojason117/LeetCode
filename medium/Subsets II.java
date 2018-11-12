class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        for(int n : nums)
            numbers.add(n);
        
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        HashSet<List<Integer>> memo = new HashSet<List<Integer>>();
        findSubsets(numbers, result, memo);
        
        return result;
    }
    
    public void findSubsets(List<Integer> nums, List<List<Integer>> result, HashSet<List<Integer>>memo) {
        Collections.sort(nums);
        
        if(memo.contains(nums))
            return;
        
        result.add(nums);
        memo.add(nums);
        
        if(nums.size() == 0)
            return;
        else {
            ArrayList<List<Integer>> subsets = permutation(nums);
            for(List<Integer> set : subsets)
                findSubsets(set, result, memo);
        }
    }
    
    public ArrayList<List<Integer>> permutation(List<Integer> nums) {
        ArrayList<List<Integer>> ps = new ArrayList<List<Integer>>();
        
        for(int i = 0; i < nums.size(); i++) {
            ArrayList<Integer> p = new ArrayList<Integer>(nums);
            p.remove(i);
            ps.add(p);
        }
        
        return ps;
    }
}