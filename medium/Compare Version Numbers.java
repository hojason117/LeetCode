class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int level = 0;
        
        while(level < v1.length || level < v2.length) {
            int l1 = (level < v1.length) ? Integer.parseInt(v1[level]) : 0;
            int l2 = (level < v2.length) ? Integer.parseInt(v2[level]) : 0;
            
            if(l1 < l2)
                return -1;
            else if(l1 > l2)
                return 1;
            else
                level++;
        }
        
        return 0;
    }
}
