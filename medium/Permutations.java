class Solution {    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(nums, result, new ArrayList<Integer>());
        return result;
    }
    
    private void helper(int[] nums, List<List<Integer>> result, List<Integer> current) {
        if(current.size() == nums.length)
            result.add(new ArrayList<Integer>(current));
        else {
            for(int i = 0; i < nums.length; i++) {
                if(current.contains(nums[i]))
                    continue;

                current.add(nums[i]);
                helper(nums, result, current);
                current.remove(current.size() - 1);
            }
        }
    }
}
