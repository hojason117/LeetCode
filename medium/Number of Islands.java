class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0)
            return 0;
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int count = 0;
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(!visited[i][j] && grid[i][j] == '1') {
                    count++;
                    propagate(i, j, grid, visited);
                }
            }
        }
        
        return count;
    }
    
    private void propagate(int row, int column, char[][] grid, boolean[][] visited) {
        if(grid[row][column] == '0')
            return;
        if(visited[row][column])
            return;
        
        visited[row][column] = true;
        
        if(row - 1 >= 0)
            propagate(row - 1, column, grid, visited);
        if(row + 1 < grid.length)
            propagate(row + 1, column, grid, visited);
        if(column - 1 >= 0)
            propagate(row, column - 1, grid, visited);
        if(column + 1 < grid[0].length)
            propagate(row, column + 1, grid, visited);
    }
}
