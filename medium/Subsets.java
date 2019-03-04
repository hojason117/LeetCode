class Solution {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    
    public List<List<Integer>> subsets(int[] nums) {
        helper(nums, 0, new ArrayList<Integer>());
        return result;
    }
    
    private void helper(int[] nums, int index, List<Integer> current) {
        result.add(new ArrayList<Integer>(current));

        for(int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            helper(nums, i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}
