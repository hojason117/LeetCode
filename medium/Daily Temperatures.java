class Solution {
    public int[] dailyTemperatures(int[] T) {
        int[] result = new int[T.length];
        
        for(int i = 0; i < T.length; i++) {
            int j = i + 1;
            for(; j < T.length; j++) {
                if(T[j] > T[i]) {
                    result[i] = j - i;
                    break;
                }
            }
            
            if(j == T.length)
                result[i] = 0;
        }
        
        return result;
    }
}