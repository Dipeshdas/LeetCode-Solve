class Pair{
    int first;
    int second;
    int third;
    
    Pair(int fst,int scnd,int thrd){
        this.first=fst;
        this.second=scnd;
        this.third=thrd;
    }
}

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]!=0) return -1;

        int n=grid.length;
        int m=grid[0].length;

        if(grid[0][0]==grid[n-1][n-1] && n==1) return 1;

        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)1e9;
            }
        }
        
        int delRow[]={1,-1,0,0,1,1,-1,-1};
        int delCol[]={0,0,1,-1,-1,1,-1,1};
        
        dist[0][0]=0;
        
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(1,0,0));
        
        while(!q.isEmpty()){
            int dis=q.peek().first;
            int row=q.peek().second;
            int col=q.peek().third;
            q.poll();
            
            for(int i=0;i<8;i++){
                int nrow=row+delRow[i];
                int ncol=col+delCol[i];
                
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==0 
                && dis+1<dist[nrow][ncol]){
                    
                    if(nrow==n-1 && ncol==n-1) return dis+1;
                    
                    q.add(new Pair(dis+1,nrow,ncol));
                    dist[nrow][ncol]=dis+1;
                }
            }
        }
        return -1;
    }
}
