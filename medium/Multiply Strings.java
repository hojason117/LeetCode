// during Facebook interview
class Solution {
    public String multiply(String num1, String num2) {
        if((num1.length() == 1 && num1.charAt(0) == '0') || (num2.length() == 1 && num2.charAt(0) == '0'))
            return "0";
        
        StringBuilder sb = new StringBuilder();
        String[] digits = new String[num2.length()];
        
        for(int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder current = new StringBuilder();
            
            for(int k = 0; k < num2.length() - 1 - i; k++)
                current.append('0');
            
            int carry = 0;
            for(int j = num1.length() - 1; j >= 0; j--) {
                int temp = (num1.charAt(j) - '0') * (num2.charAt(i) - '0');
                temp += carry;
                current.insert(0, (char)('0' + temp % 10));
                carry = temp / 10;
            }
            
            if(carry != 0)
                current.insert(0, (char)('0' + carry));
            
            digits[i] = current.toString();
        }
        
        int carry = 0;
        for(int i = 0; i < digits[0].length(); i++) {
            int temp = 0;
            for(String s : digits) {
                if(i < s.length())
                    temp += s.charAt(s.length() - 1 - i) - '0';
            }
            temp += carry;
            sb.insert(0, (char)('0' + temp % 10));
            carry = temp / 10;
        }
        
        if(carry != 0)
            sb.insert(0, (char)('0' + carry));
        
        return sb.toString();
    }
}
