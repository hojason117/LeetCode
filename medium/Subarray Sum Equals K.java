// hashmap
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> sumsCount = new HashMap<Integer, Integer>();
        sumsCount.put(0, 1);
        
        for(int i : nums) {
            sum += i;
            if(sumsCount.containsKey(sum - k))
                count += sumsCount.get(sum - k);
            sumsCount.put(sum, sumsCount.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
}

// cumulative sum
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int tempSum = sum;
            for(int j = 0; j <= i; j++) {
                if(tempSum == k)
                    count++;
                tempSum -= nums[j];
            }
        }
        
        return count;
    }
}
