// backtracking
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        helper("", n, 0, 0, result);
        
        return result;
    }
    
    private void helper(String current, int n, int left, int right, List<String> result) {
        if(left == n && right == n)
            result.add(current);
        else {
            if(left == right)
                helper(current + '(', n, left + 1, right, result);
            else if(left > right) {
                if(left < n)
                    helper(current + '(', n, left + 1, right, result);
                helper(current + ')', n, left, right + 1, result);
            }
        }
    }
}

// brute force
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        helper("", n, 0, 0, result);
        
        return result;
    }
    
    private void helper(String current, int n, int left, int right, List<String> result) {
        if(right > left)
            return;
        
        if(left == n && right == n) {
            if(verify(current, n))
                result.add(current);
        }
        else {
            if(left != n)
                helper(current + '(', n, left + 1, right, result);
            if(right != n)
                helper(current + ')', n, left, right + 1, result);
        }
    }
    
    private boolean verify(String target, int n) {
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < target.length(); i++) {
            if(target.charAt(i) == '(')
                stack.push('(');
            else {
                if(stack.size() > 0 && stack.peek() == '(')
                    stack.pop();
                else
                    return false;
            }
        }
        
        return stack.size() == 0;
    }
}
