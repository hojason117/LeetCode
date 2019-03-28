class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<String, List<String>>();
        
        for(String s : strs) {
            int[] count = new int[26];
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < s.length(); i++)
                count[s.charAt(i) - 'a']++;
            
            for(int i : count)
                sb.append("" + i + ' ');
            
            String key = sb.toString();
            if(!groups.containsKey(key))
                groups.put(key, new ArrayList<String>());
            groups.get(key).add(s);
        }
        
        return new ArrayList<List<String>>(groups.values());
    }
}
