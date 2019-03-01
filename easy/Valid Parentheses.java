class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if(current == '(' || current == '{' || current == '[')
                stack.push(current);
            else if(stack.size() > 0 && ((current == ')' && stack.peek() == '(') || (current == '}' && stack.peek() == '{') || (current == ']' && stack.peek() == '[')))
                stack.pop();
            else
                return false;
        }
        
        return stack.size() == 0;
    }
}
