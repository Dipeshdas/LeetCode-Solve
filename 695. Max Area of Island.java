class Pair{
    int first;
    int second;
    Pair(int fst,int scnd){
        this.first=fst;
        this.second=scnd;
    }
}

class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        int visited[][]=new int[n][m];
        int count=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]==1){
                    count=BFS(grid,visited,i,j,0);
                }
                max=Math.max(count,max);
            }
        }
        return max;
    }

    public int BFS(int[][]grid,int[][]visited,int i,int j,int count){
        visited[i][j]=1;
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(i,j));
        
        count++;
        int n=grid.length;
        int m=grid[0].length;

        int delRow[]={-1,1,0,0};
        int delCol[]={0,0,-1,1};
        while(!q.isEmpty()){
            int row=q.peek().first;
            int col=q.peek().second;
            q.poll();

            for(int k=0;k<4;k++){
                int nrow=row+delRow[k];
                int ncol=col+delCol[k];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visited[nrow][ncol]==0 &&
                grid[nrow][ncol]==1){
                    count++;
                    visited[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
        return count;
    }
}
