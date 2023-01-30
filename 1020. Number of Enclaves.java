class Solution {

    public void dfs(int sr,int sc,int visited[][],int[][] grid,int delRow[],int delCol[],int n,
    int m){
        visited[sr][sc]=1;

        for(int i=0;i<4;i++){
            int nrow=sr+delRow[i];
            int ncol=sc+delCol[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 &&
            grid[nrow][ncol]==1){
                dfs(nrow,ncol,visited,grid,delRow,delCol,n,m);
            }
        }
    }

    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int visited[][]=new int[n][m];
        int delRow[]={-1,1,0,0};
        int delCol[]={0,0,-1,1};

        //first we are checking for boundaries 1
        //check for first row and last row
        for(int j=0;j<m;j++){

            //first row
            if(visited[0][j]==0 && grid[0][j]==1){
                dfs(0,j,visited,grid,delRow,delCol,n,m);
            }

            //last row
            if(visited[n-1][j]==0 && grid[n-1][j]==1){
                dfs(n-1,j,visited,grid,delRow,delCol,n,m);
            }
        }

        //check for first col and last col
        for(int i=0;i<n;i++){
            //first col
            if(visited[i][0]==0 && grid[i][0]==1){
                dfs(i,0,visited,grid,delRow,delCol,n,m);
            }

            //last col
            if(visited[i][m-1]==0 && grid[i][m-1]==1){
                dfs(i,m-1,visited,grid,delRow,delCol,n,m);
            }
        }

        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
}
