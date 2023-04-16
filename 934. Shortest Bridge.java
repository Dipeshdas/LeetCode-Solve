class Pair{
    int row;
    int col;
    Pair(int row,int col){
        this.row=row;
        this.col=col;
    }

}

class Solution {
    public int shortestBridge(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int visit[][]=new int[n][m];
        Queue<Pair>q=new LinkedList<>();

        int delRow[]={1,-1,0,0};
        int delCol[]={0,0,1,-1};

        boolean flag=false;
        
        for(int i=0;i<n && !flag;i++){
            for(int j=0;j<m && !flag;j++){
                if(visit[i][j]==0 && grid[i][j]==1){
                    dfs(i,j,grid,visit,q,delRow,delCol);
                    flag=true;
                }
            }
        }
    

        int count=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                Pair pr=q.poll();
                int row=pr.row;
                int col=pr.col;
                visit[row][col]=1;

                for(int i=0;i<4;i++){
                    int nrow=row+delRow[i];
                    int ncol=col+delCol[i];

                    if(nrow<n && nrow>=0 && ncol<m && ncol>=0 && visit[nrow][ncol]==0){  
                        q.add(new Pair(nrow,ncol));
                        visit[nrow][ncol]=1;
                        if(grid[nrow][ncol]==1){
                            return count;
                        }
                    }    
                }

            }
            count++;
            
        }
        return -1;


    }

    public static void dfs(int row,int col,int [][]grid,int visit[][],Queue<Pair>q,int delRow[],int delCol[]){
        int n=grid.length;
        int m=grid[0].length;
        q.add(new Pair(row,col));
        visit[row][col]=1;

        for(int i=0;i<4;i++){
            int nrow=row+delRow[i];
            int ncol=col+delCol[i];

            if(nrow<n && nrow>=0 && ncol<m && ncol>=0 && visit[nrow][ncol]==0 && grid[nrow][ncol]==1){  
                dfs(nrow,ncol,grid,visit,q,delRow,delCol);
            }
            
        }
        
    }


}
