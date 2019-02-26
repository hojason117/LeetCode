class Solution {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int pa = a.length() - 1;
        int pb = b.length() - 1;
        boolean carry = false;
        
        while(pa >= 0 || pb >= 0 || carry) {
            int count = carry ? 1 : 0;
            if(pa >= 0 && a.charAt(pa) == '1')
                count++;
            if(pb >= 0 && b.charAt(pb) == '1')
                count++;
            
            result.insert(0, (count % 2 == 0) ? 0 : 1);
            carry = count / 2 == 1;
            
            pa--;
            pb--;
        }
        
        return result.toString();
    }
}
