class Solution {
    public String countAndSay(int n) {
        String result = "1";
        
        for(int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            char current = result.charAt(0);
            int count = 1;
            
            for(int j = 1; j < result.length(); j++) {
                if(result.charAt(j) != current) {
                    sb.append(String.format("%d%c", count, current));
                    current = result.charAt(j);
                    count = 1;
                }
                else
                    count++;
            }
            sb.append(String.format("%d%c", count, current));
            
            result = sb.toString();
        }
        
        return result;
    }
}
