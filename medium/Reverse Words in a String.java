// string builtin
class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        if(words.length == 0)
            return "";
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = words.length - 1; i >= 0; i--)
            sb.append(words[i] + ' ');
        
        return sb.toString().substring(0, sb.length() - 1);
    }
}

// pointers
class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0)
            return "";
            
        StringBuilder sb = new StringBuilder();
        int pointer = s.length() - 1;
        
        for(int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) == ' ') {
                if(pointer == i)
                    pointer--;
                else {
                    sb.append(s.substring(i + 1, pointer + 1) + ' ');
                    pointer = i - 1;
                }
            }
        }
        
        if(s.charAt(0) != ' ')
            sb.append(s.substring(0, pointer + 1) + ' ');
        
        return (sb.length() != 0) ? sb.toString().substring(0, sb.length() - 1) : "";
    }
}
