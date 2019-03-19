class NumMatrix {
    int[][] cache = new int[0][];

    public NumMatrix(int[][] matrix) {
        if(matrix.length == 0)
            return;
        
        cache = new int[matrix.length][matrix[0].length];
        
        for(int i = 0; i < matrix.length; i++) {
            int sum = 0;
            for(int j = 0; j < matrix[0].length; j++) {
                sum += matrix[i][j];
                cache[i][j] = sum;
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        
        for(int i = row1; i <= row2; i++) {
            sum += cache[i][col2];
            if(col1 > 0)
                sum -= cache[i][col1 - 1];
        }
        
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */
 