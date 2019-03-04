class Solution {
    List<String> result = new ArrayList<String>();
    Map<Character, char[]> map = new HashMap<Character, char[]>();
        
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return result;
        
        map.put('2', new char[]{'a', 'b', 'c'});
        map.put('3', new char[]{'d', 'e', 'f'});
        map.put('4', new char[]{'g', 'h', 'i'});
        map.put('5', new char[]{'j', 'k', 'l'});
        map.put('6', new char[]{'m', 'n', 'o'});
        map.put('7', new char[]{'p', 'q', 'r', 's'});
        map.put('8', new char[]{'t', 'u', 'v'});
        map.put('9', new char[]{'w', 'x', 'y', 'z'});
        
        helper(digits, 0, "");
        
        return result;
    }
    
    private void helper(String digits, int index, String current) {
        if(index == digits.length())
            result.add(current);
        else {
            for(char c : map.get(digits.charAt(index)))
                helper(digits, index + 1, current + c);
        }
    }
}
