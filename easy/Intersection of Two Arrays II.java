// sorting, time: O(max(m,n)log(max(m,n))), space: O(1)
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        List<Integer> result = new ArrayList<Integer>();
        int[] longer = (nums1.length >= nums2.length) ? nums1 : nums2;
        int[] shorter = (nums1.length < nums2.length) ? nums1 : nums2;
        int pointer = 0, max = shorter.length;
        for(int i = 0; i < max; i++) {
            while(pointer < longer.length && longer[pointer] < shorter[i])
                pointer++;
            
            if(pointer < longer.length && longer[pointer] == shorter[i]) {
                result.add(shorter[i]);
                pointer++;
            }
        }
        
        int[] container = new int[result.size()];
        for(int i = 0; i < container.length; i++)
            container[i] = result.get(i);
        
        return container;
    }
}

// HashMap, time: O(m+n), space: O(max(m,n))
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int[] longer = (nums1.length >= nums2.length) ? nums1 : nums2;
        Map<Integer, Integer> counts = new HashMap<Integer, Integer>();
        for(int i : longer) {
            if(counts.get(i) == null)
                counts.put(i, 0);
            counts.put(i, counts.get(i) + 1);
        }
        
        int[] shorter = (nums1.length < nums2.length) ? nums1 : nums2;
        List<Integer> result = new ArrayList<Integer>();
        for(int i : shorter) {
            if(counts.get(i) != null && counts.get(i) > 0) {
                counts.put(i, counts.get(i) - 1);
                result.add(i);
            }
        }
        
        int[] container = new int[result.size()];
        for(int i = 0; i < container.length; i++)
            container[i] = result.get(i);
        
        return container;
    }
}
