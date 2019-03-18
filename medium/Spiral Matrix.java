class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix.length == 0)
            return new ArrayList<Integer>();
        
        int m = matrix.length, n = matrix[0].length, layer = Math.min((m + 1) / 2, (n + 1) / 2);
        List<Integer> result = new ArrayList<Integer>();
        
        for(int i = 0; i < layer; i++) {
            for(int j = i; j < n - i; j++)
                result.add(matrix[i][j]);
            for(int j = i + 1; j < m - i; j++)
                result.add(matrix[j][n - i - 1]);
            
            if((i == m - i - 1) || (n - i - 1 == i))
                break;
            
            for(int j = n - i - 2; j >= i; j--)
                result.add(matrix[m - i - 1][j]);
            for(int j = m - i - 2; j >= i + 1; j--)
                result.add(matrix[j][i]);
        }
        
        return result;
    }
}
