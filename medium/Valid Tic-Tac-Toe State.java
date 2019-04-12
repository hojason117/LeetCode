class Solution {
    public boolean validTicTacToe(String[] board) {
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag = 0, antiDiag = 0;
        int xCount = 0, oCount = 0;
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                char ch = board[i].charAt(j);
                if(ch != ' ') {
                    if(ch == 'X')
                        xCount++;
                    else
                        oCount++;
                    
                    rows[i] += ch == 'X' ? 1 : -1;
                    cols[j] += ch == 'X' ? 1 : -1;
                    if(i == j)
                        diag += ch == 'X' ? 1 : -1;
                    if(i + j == 2)
                        antiDiag += ch == 'X' ? 1 : -1;
                }
            }
        }
        
        boolean xWins = false, oWins = false;
        for(int i = 0; i < 3; i++) {
            if(rows[i] == 3 || cols[i] == 3)
                xWins = true;
            if(rows[i] == -3 || cols[i] == -3)
                oWins = true;
        }
        
        if(diag == 3 || antiDiag == 3)
            xWins = true;
        if(diag == -3 || antiDiag == -3)
            oWins = true;
        
        if(oCount > xCount || xCount - oCount > 1 || (xWins && xCount - oCount != 1) || (oWins && xCount != oCount))
            return false;
        
        return !(xWins && oWins);
    }
}
