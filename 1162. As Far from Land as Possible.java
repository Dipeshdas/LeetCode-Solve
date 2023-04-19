class Pair{
    int row;
    int col;
    int steps;
    Pair(int row,int col,int steps){
        this.row=row;
        this.col=col;
        this.steps=steps;
    }
}

class Solution {
    public int maxDistance(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int visit[][]=new int[n][m];

        Queue<Pair>q=new LinkedList<>();
        

        int delRow[]={1,-1,0,0};
        int delCol[]={0,0,1,-1};

        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    q.add(new Pair(i,j,0));
                    visit[i][j]=1;
                }
            }
        }

        int res=-1;
        while(!q.isEmpty()){
            int row=q.peek().row;
            int col=q.peek().col;
            int steps=q.peek().steps;

            res=Math.max(res,steps);

            q.poll();
            for(int k=0;k<4;k++){
                int nrow=row+delRow[k];
                int ncol=col+delCol[k];

                if(nrow<n && nrow>=0 && ncol<m && ncol>=0 && visit[nrow][ncol]==0){
                    q.add(new Pair(nrow,ncol,steps+1));
                    visit[nrow][ncol]=1;
                }
            }
        }

        return res==0?-1:res;
    }
}
