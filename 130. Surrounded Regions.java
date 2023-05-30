class Solution {

    public void dfs(int row,int col,int[][]visit,char board[][],int delRow[],int delCol[],int n,int m){
        visit[row][col]=1;
        for(int i=0;i<4;i++){
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visit[nrow][ncol]==0 && board[nrow][ncol]=='O'){
                dfs(nrow,ncol,visit,board,delRow,delCol,n,m);
            }
        }
    }

    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        int visit[][]=new int[n][m];

        int delRow[]={1,-1,0,0};
        int delCol[]={0,0,1,-1};

        //For Row 
        for(int i=0;i<m;i++){
            //first row
            if(visit[0][i]==0 && board[0][i]=='O'){
                dfs(0,i,visit,board,delRow,delCol,n,m);
            }
            //last row
            if(visit[n-1][i]==0 && board[n-1][i]=='O'){
                dfs(n-1,i,visit,board,delRow,delCol,n,m);
            }
        }

        //FOR Column
        for(int i=0;i<n;i++){
            //first col
            if(visit[i][0]==0 && board[i][0]=='O'){
                dfs(i,0,visit,board,delRow,delCol,n,m);
            }
            //last col
            if(visit[i][m-1]==0 && board[i][m-1]=='O'){
                dfs(i,m-1,visit,board,delRow,delCol,n,m);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visit[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }  
    }
}

