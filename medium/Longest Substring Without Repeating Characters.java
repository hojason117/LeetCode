class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max = 0, temp = 0, start = 0, end = 0;
        Map<Character, Integer> seen = new HashMap<Character, Integer>();
        
        while(end < s.length()) {
            if(seen.containsKey(s.charAt(end)) && seen.get(s.charAt(end)) >= start) {
                start = seen.get(s.charAt(end)) + 1;
                temp = end - start + 1;
            }
            else
                temp++;
            
            seen.put(s.charAt(end), end);
            end++;
            
            if(temp > max)
                max = temp;
        }
        
        return max;
    }
}
