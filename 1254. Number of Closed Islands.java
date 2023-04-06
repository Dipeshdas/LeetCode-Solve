class Tuple{
    int row;
    int col;
    Tuple(int row,int col){
        this.row=row;
        this.col=col;
    }
}

class Solution {
    public int closedIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int delRow[]={1,-1,0,0};
        int delCol[]={0,0,1,-1};

        boolean visit[][]=new boolean[n][m];
        int ans=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!visit[i][j] && grid[i][j]==0){
                    ans=bfs(grid,i,j,visit,ans,delRow,delCol);
                }
            }
        }
        return ans;
    }
    public int bfs(int[][]grid,int row,int col,boolean visit[][],int ans,int delRow[],int delCol[]){
        Queue<Tuple>q=new LinkedList<>();
        int n=grid.length;
        int m=grid[0].length;
        q.add(new Tuple(row,col));
        boolean closed=true;
        while(!q.isEmpty()){
            Tuple pr=q.poll();
            for(int i=0;i<4;i++){
                int nrow=pr.row+delRow[i];
                int ncol=pr.col+delCol[i];

                if(nrow<0 || nrow>=n || ncol<0 || ncol>=m){
                    closed=false;
                    continue;
                }
                if(grid[nrow][ncol]==1 || visit[nrow][ncol]) continue;

                visit[nrow][ncol]=true;
                q.add(new Tuple(nrow,ncol));
            }
        }
        if(closed) ans++;
        return ans;
    }
}
