class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] letterOrder = new int[26];
        for(int i = 0; i < 26; i++)
            letterOrder[order.charAt(i) - 'a'] = i;
        
        for(int i = 1; i < words.length; i++) {
            for(int j = 0; ; j++) {
                if(j == words[i].length() || j == words[i - 1].length()) {
                    if(words[i].length() < words[i - 1].length())
                        return false;
                    else
                        break;
                }
                
                if(letterOrder[words[i].charAt(j) - 'a'] < letterOrder[words[i - 1].charAt(j) - 'a'])
                    return false;
                else if(letterOrder[words[i].charAt(j) - 'a'] > letterOrder[words[i - 1].charAt(j) - 'a'])
                    break;
            }
        }
        
        return true;
    }
}
