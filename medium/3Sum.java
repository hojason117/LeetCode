// w/o Set
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;
            
            int left = i + 1, right = nums.length - 1;
            int target = -nums[i];
            while(left < right) {
                if(nums[left] + nums[right] == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    int leftValue = nums[left];
                    int rightValue = nums[right];
                    while(left < right && nums[left] == leftValue)
                        left++;
                    while(left < right && nums[right] == rightValue)
                        right--;
                }
                else if(nums[left] + nums[right] < target)
                    left++;
                else
                    right--;
            }
        }
        
        return result;
    }
}

// w/ Set
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, Integer> valToIndex = new HashMap<Integer, Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Set<String> resultSet = new HashSet<String>();
        
        for(int i = 0; i < nums.length; i++)
            valToIndex.put(nums[i], i);
        
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                Integer index = valToIndex.get(-(nums[i] + nums[j]));
                if(index != null && index != i && index != j) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[index]);
                    Collections.sort(temp);
                    String sig = String.format("%d,%d,%d", temp.get(0), temp.get(1), temp.get(2));
                    
                    if(!resultSet.contains(sig)) {
                        result.add(temp);
                        resultSet.add(sig);
                    }
                }
            }
        }
        
        return result;
    }
}
