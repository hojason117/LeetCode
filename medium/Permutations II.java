class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        helper(nums, result, new ArrayList<Integer>(), new boolean[nums.length]);
        return result;
    }
    
    private void helper(int[] nums, List<List<Integer>> result, List<Integer> current, boolean[] selected) {
        if(current.size() == nums.length)
            result.add(new ArrayList<Integer>(current));
        else {
            for(int i = 0; i < nums.length; i++) {
                if(!selected[i] && (i == 0 || !(nums[i] == nums[i-1] && !selected[i-1]))) {
                    current.add(nums[i]);
                    selected[i] = true;
                    helper(nums, result, current, selected);
                    current.remove(current.size() - 1);
                    selected[i] = false;
                }
            }
        }
    }
}
