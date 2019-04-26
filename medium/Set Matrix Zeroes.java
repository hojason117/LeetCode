class Solution {
    public void setZeroes(int[][] matrix) {
        boolean zeroFirstRow = false, zeroFirstColumn = false;
        
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                    if(i == 0)
                        zeroFirstRow = true;
                    if(j == 0)
                        zeroFirstColumn = true;
                }
            }
        }
        
        for(int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0)
                zeroRow(matrix, i);
        }
        
        for(int j = 1; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0)
                zeroColumn(matrix, j);
        }
        
        if(zeroFirstRow)
            zeroRow(matrix, 0);
        if(zeroFirstColumn)
            zeroColumn(matrix, 0);
    }
    
    private void zeroRow(int[][] matrix, int row) {
        for(int i = 0; i < matrix[0].length; i++)
            matrix[row][i] = 0;
    }
    
    private void zeroColumn(int[][] matrix, int column) {
        for(int i = 0; i < matrix.length; i++)
            matrix[i][column] = 0;
    }
}
