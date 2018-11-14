class Solution {
    HashSet<String> words = new HashSet<String>();
    HashMap<Integer, Boolean> memo = new HashMap<Integer, Boolean>();
    
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String w : wordDict)
            words.add(w);
        
        return validate(s, 0);
    }
    
    private boolean validate(String s, int start) {
        if(start == s.length())
            return true;
        
        if(memo.containsKey(start))
            return memo.get(start);
        
        int end = s.length();
        for(int i = start + 1; i <= end; i++) {
            if(words.contains(s.substring(start, i))) {
                if(validate(s, i)) {
                    memo.put(i, true);
                    return true;
                }
                memo.put(i, false);
            }
        }
        
        return false;
    }
}