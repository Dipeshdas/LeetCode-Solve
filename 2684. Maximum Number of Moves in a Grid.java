
class Pair{
    int first;
    int second;
    
    Pair(int first,int second){
        this.first=first;
        this.second=second;

    }
}

class Solution {
    public int maxMoves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int visit[][]=new int[n][m];
        
        int delRow[]={-1,0,1};
        int delCol[]={1,1,1};
        
        int ans[]={-1};
        int max=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visit[i][j]==0 && j==0){
                    bfs(i,j,grid,visit,delRow,delCol,n,m,ans);
                    max=Math.max(max,ans[0]);
                    ans[0]=-1;
                }
            }
        }
        return max;
    }
    
    public void bfs(int start,int end,int[][]grid,int [][]visit,int delRow[],int delCol[],int n,int m,int ans[]){
        
        Queue<Pair>q=new LinkedList<>();
        q.add(new Pair(start,end));
        visit[start][end]=1;
        
        while(!q.isEmpty()){
            int size=q.size();
            for(int len=0;len<size;len++){
                    int row=q.peek().first;
                    int col=q.peek().second;
                    q.poll();
                            
                    for(int i=0;i<3;i++){
                        int nrow=row+delRow[i];
                        int ncol=col+delCol[i];
                    
                        if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && visit[nrow][ncol]==0 && grid[nrow][ncol]>grid[row][col]){
                            
                            
                            q.add(new Pair(nrow,ncol));
                            visit[nrow][ncol]=1;
                        }
                    }
            }   
            ans[0]++;
            // System.out.println(ans[0]);
        }
        
        
    }
}
