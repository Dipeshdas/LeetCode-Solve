class Pair{
    int first;
    int second;
    Pair(int fst,int scnd){
        this.first=fst;
        this.second=scnd;
    }
}

class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int visited[][]=new int[n][m];

        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    count++;
                    BFS(i,j,grid,visited);
                }
            }
        }
        return count;
    }

    public void BFS(int row,int col,char[][] grid,int visited[][]){
        visited[row][col]=1;
        Queue<Pair>q=new LinkedList<Pair>();
        q.add(new Pair(row,col));
        int n=grid.length;
        int m=grid[0].length;

        int delRow[]={-1,1,0,0};
        int delCol[]={0,0,1,-1};
        while(!q.isEmpty()){
            int nrow=q.peek().first;
            int ncol=q.peek().second;
            q.poll();

            for(int i=0;i<4;i++){
                int deltaRow=nrow+delRow[i];
                int deltaCol=ncol+delCol[i];

                if(deltaRow>=0 && deltaRow<n && deltaCol>=0 && deltaCol<m && visited[deltaRow][deltaCol]==0 && grid[deltaRow][deltaCol]=='1'){
                    visited[deltaRow][deltaCol]=1;
                    q.add(new Pair(deltaRow,deltaCol));
                }
            }
        }

    }
}
