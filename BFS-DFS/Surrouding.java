class Solution {
    int[] dx = new int[]{0,0,1,-1};
    int[] dy = new int[]{1,-1,0,0};
    public void dfs(int x, int y, int[][] v,char[][] b){
        v[x][y] = 1;
        for(int i = 0;i<4;i++) {
            int r = x + dx[i];
            int c = y + dy[i]; 
            if(r >=0 && r <b.length && c >= 0 && c < b[0].length && v[r][c] == 0 && b[r][c] == 'O') {
                dfs(r, c, v, b); 
            }
        }
    }
    public void solve(char[][] board) {
        int[][] v = new int[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            if(v[i][0] == 0 && board[i][0] == 'O'){
                dfs(i,0,v,board);
            }
            if(v[i][board[0].length-1] == 0 && board[i][board[0].length-1] == 'O'){
                dfs(i,board[0].length-1,v,board);
            }
        }
        for(int i = 0;i<board[0].length;i++){
            if(v[0][i] == 0 && board[0][i] == 'O'){
                dfs(0,i,v,board);
            }
            if(v[board.length-1][i] == 0 && board[board.length-1][i] == 'O'){
                dfs(board.length-1,i,v,board);
            }
        }

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(v[i][j] == 0 && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        // return board;
    }
}
