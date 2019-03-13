class Solution {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<String>();
        helper(S, result, "");
        return result;
    }
    
    private void helper(String S, List<String> result, String current) {
        if(current.length() == S.length())
            result.add(current);
        else {
            char temp = S.charAt(current.length());
            if(temp >= '0' && temp <= '9')
                helper(S, result, current + temp);
            else {
                helper(S, result, current + Character.toLowerCase(temp));
                helper(S, result, current + Character.toUpperCase(temp));
            }
        }
    }
}
