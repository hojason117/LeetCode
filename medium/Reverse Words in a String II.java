class Solution {
    public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);
        
        int start = 0;
        for(int i = 0; i < str.length; i++) {
            if(str[i] == ' ') {
                reverse(str, start, i - 1);
                start = i + 1;
            }
        }
        
        reverse(str, start, str.length - 1);
    }
    
    private void reverse(char[] str, int start, int end) {
        for(int i = 0; i < (end - start + 1) / 2; i++) {
            char temp = str[start + i];
            str[start + i] = str[end - i];
            str[end - i] = temp;
        }
    }
}
